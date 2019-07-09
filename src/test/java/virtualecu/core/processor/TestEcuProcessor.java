package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.BS;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;

public class TestEcuProcessor {
	private TPS tps;
	private MAP map;
	private BS bs;
	private ECT ect;
	private CKP ckp;
	private EcuProcessor ecuProcessor;
	
	@Before
	public void setUp() {
		tps = new TPS();
		map = new MAP();
		bs = new BS();
		ect = new ECT(true);
		ckp = new CKP();
		ecuProcessor = new EcuProcessor();
	}

	@Test
	public void testCheckCoolantTemperature() {
		ect.setTemperature(20.3f);
		ecuProcessor.setEct(ect);
		String message = ecuProcessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching minimum threshold in 46 secs")));
	}
	
	@Test
	public void testCheckCoolantTemperatureMax() {
		map.setHg(2.7f);
		bs.setHg(2.4f);
		tps.setAngle(40);
		ect.setTemperature(20.3f);
		ecuProcessor.setCkp(ckp);
		ecuProcessor.setEct(ect);
		ecuProcessor.measureAirDensity(map, bs);
		ecuProcessor.dosifyFuel(tps);
		String message = ecuProcessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching max threshold in 15 secs")));
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
		
		ecuProcessor.setCkp(ckp);
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
		
		ecuProcessor.setCkp(ckp);
		ecuProcessor.setEct(ect);
		ecuProcessor.measureAirDensity(map, bs);
		ecuProcessor.dosifyFuel(tps);
		
		assertThat(ecuProcessor.getInjectorState(), is("injecting fuel, normal mode"));
	}
}
