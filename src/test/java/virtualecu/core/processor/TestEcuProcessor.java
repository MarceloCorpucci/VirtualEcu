package virtualecu.core.processor;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestEcuProcessor {
	private EcuProcessor ecuProcessor;
	
	@Before
	public void setUp() {
		ecuProcessor = new EcuProcessor();
	}

	@Test
	public void testFuelPumpAttribute() {
		assertThat(ecuProcessor, hasProperty("fuelPump"));	
	}
	
	@Test
	public void testIgnitionModuleAttribute() {
		assertThat(ecuProcessor, hasProperty("ignitionModule"));	
	}
	
	@Test
	public void testEctAttribute() {
		assertThat(ecuProcessor, hasProperty("ect"));	
	}
	
	@Test
	public void testCkpAttribute() {
		assertThat(ecuProcessor, hasProperty("ckp"));	
	}
	
	@Test
	public void testInjectorAttribute() {
		assertThat(ecuProcessor, hasProperty("injector"));	
	}
	
}
