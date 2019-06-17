package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.TPS;

public class TestEcuProcessor {
	private TPS tps;
	private EcuProcessor processor;
	
	@Before
	public void setUp() {
		tps = new TPS();
		processor = new EcuProcessor();
	}
	
	@Test
	public void testDosifyFuelAtFullCapacity() {
		tps.setAngle(40);
		processor.dosifyFuel(tps);
		
		assertThat(processor.getInjectorState(), is("injecting fuel, full capacity"));
	}
	
	@Test
	public void testDosifyFuelAtNormalCapacity() {
		tps.setAngle(60);
		processor.dosifyFuel(tps);
		
		assertThat(processor.getInjectorState(), is("injecting fuel"));
	}
}
