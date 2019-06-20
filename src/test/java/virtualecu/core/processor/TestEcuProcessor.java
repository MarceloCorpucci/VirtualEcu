package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.BS;
import virtualecu.core.input.ECT;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;

public class TestEcuProcessor {
	private TPS tps;
	private MAP map;
	private BS bs;
	private ECT ect;
	private EcuProcessor ecuProcessor;
	
	@Before
	public void setUp() {
		tps = new TPS();
		map = new MAP();
		bs = new BS();
		ect = new ECT(true);
		ecuProcessor = new EcuProcessor();
	}

	@Test
	public void testCheckCoolantTemperature() {
		//1.- set ect with 20.3f
		//2.- set EcuProcessor ect
		//3.- exercise checkCoolantTemperature() method!
		
		//4.- assert that message is equal to "Checking coolant temp, reaching minimum threshold in 46 secs"
		assertThat(true, is(equalTo(false)));
	}
	
	@Test
	public void testCheckCoolantTemperatureMax() {
		//1.- set map to (2.7f);
		//2.- set bs to(2.4f);
		//3.- set tps to (40);
		//4.- set ect to (20.3f);
		//5.- set ecuProcessor ect attribute;
		//6.- invoke ecuProcessor.measureAirDensity(map, bs);
		//7.- invoke ecuProcessor.dosifyFuel(tps);
		//8.- exercise checkCoolantTemperature() method!
		
		//4.- assert that message is equal to "Checking coolant temp, reaching max threshold in 15 secs"
		assertThat(true, is(equalTo(false)));
	}
	
	@Test
	public void testMeasureAirDensityLow() {
		map.setHg(2.7f);
		bs.setHg(2.1f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("low")));
	}
	
	@Test
	public void testMeasureAirDensityNormal() {
		map.setHg(5.1f);
		bs.setHg(3.1f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("normal")));
	}
	
	@Test
	public void testMeasureAirDensityHigh() {
		map.setHg(7.7f);
		bs.setHg(3.8f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("high")));
	}
	
	@Test
	public void testMeasureAirDensityFailed() {
		map.setHg(7.7f);
		bs.setHg(1.8f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("failed")));
	}
	
	@Test
	public void testDosifyFuelAtFullCapacity() {
		tps.setAngle(40);
		map.setHg(7.7f);
		bs.setHg(3.8f);
		
		ecuProcessor.setEct(ect);
		ecuProcessor.measureAirDensity(map, bs);
		ecuProcessor.dosifyFuel(tps);
		
		assertThat(ecuProcessor.getInjectorState(), is("injecting fuel, full capacity"));
	}
	
	@Test
	public void testDosifyFuelAtNormalCapacity() {
		tps.setAngle(60);
		map.setHg(2.7f);
		bs.setHg(2.1f);
		
		ecuProcessor.setEct(ect);
		ecuProcessor.measureAirDensity(map, bs);
		ecuProcessor.dosifyFuel(tps);
		
		assertThat(ecuProcessor.getInjectorState(), is("injecting fuel, normal mode"));
	}
}
