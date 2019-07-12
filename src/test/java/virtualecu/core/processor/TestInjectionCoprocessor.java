package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.BS;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;
import virtualecu.core.output.FuelInjector;
import virtualecu.core.output.IgnitionControlModule;

public class TestInjectionCoprocessor {
	private TPS tps;
	private MAP map;
	private BS bs;
	private ECT ect;
	CKP ckp;
	private FuelInjector fuelInjector;
	private IgnitionControlModule ignitionModule;
	private InjectionCoprocessor injectionCoprocessor;
	private MeasurementCoprocessor measurementCoprocessor;
	
	@Before
	public void setUp() {
		map = new MAP();
		bs = new BS();

		tps = new TPS();

		fuelInjector = new FuelInjector(true);
		ckp = new CKP();
		ckp.setUnitValue();
		ignitionModule = new IgnitionControlModule();
		ect = new ECT(true);
		injectionCoprocessor = new InjectionCoprocessor();
		injectionCoprocessor.setInjector(fuelInjector);
		injectionCoprocessor.setCkp(ckp);
		injectionCoprocessor.setIgnitionModule(ignitionModule);
		injectionCoprocessor.setEct(ect);
		
		measurementCoprocessor =  new MeasurementCoprocessor();
	}
	
	@Test
	public void testDosifyFuelAtFullCapacity() {
		tps.setUnitValue(40);
		map.setUnitValue(6.7f);
		bs.setUnitValue(2.4f);
		
		String airDensity = measurementCoprocessor.measureAirDensity(map, bs);
		injectionCoprocessor.dosifyFuel(tps, airDensity);
		
		assertThat(injectionCoprocessor.getInjectorState(), is("injecting fuel, full capacity"));
	}
	
	@Test
	public void testDosifyFuelAtNormalCapacity() {
		tps.setUnitValue(60);
		map.setUnitValue(2.7f);
		bs.setUnitValue(2.1f);
		
		String airDensity = measurementCoprocessor.measureAirDensity(map, bs);
		injectionCoprocessor.dosifyFuel(tps, airDensity);
		
		assertThat(injectionCoprocessor.getInjectorState(), is("injecting fuel, normal mode"));
	}
}
