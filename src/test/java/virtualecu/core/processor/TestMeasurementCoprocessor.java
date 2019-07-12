package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.BS;
import virtualecu.core.input.ECT;
import virtualecu.core.input.MAP;

public class TestMeasurementCoprocessor {
	private MAP map;
	private BS bs;
	private ECT ect;
	private MeasurementCoprocessor measurementCoprocessor;

	@Before
	public void setUp() {
		map = new MAP();
		bs = new BS();
		ect = new ECT(true);
		measurementCoprocessor = new MeasurementCoprocessor();
	}

	@Test
	public void testCheckCoolantTemperatureMinThreshold() {
		ect.setUnitValue(20.3f);
		measurementCoprocessor.setEct(ect);
		String message = measurementCoprocessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching minimum threshold in 46 secs")));
	}

	@Test
	public void testCheckCoolantTemperatureMaxThreshold() {
		ect.setUnitValue(70.3f);
		measurementCoprocessor.setEct(ect);
		String message = measurementCoprocessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching max threshold in 16 secs")));
	}
	
	@Test
	public void testMeasureAirDensityLow() {
		map.setUnitValue(2.7f);
		bs.setUnitValue(2.1f);
		
		String currentAirDensity = measurementCoprocessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("low")));
	}
	
	@Test
	public void testMeasureAirDensityNormal() {
		map.setUnitValue(5.1f);
		bs.setUnitValue(3.1f);
		
		String currentAirDensity = measurementCoprocessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("normal")));
	}
	
	@Test
	public void testMeasureAirDensityHigh() {
		map.setUnitValue(7.7f);
		bs.setUnitValue(3.8f);
		
		String currentAirDensity = measurementCoprocessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("high")));
	}
	
	@Test
	public void testMeasureAirDensityFailed() {
		map.setUnitValue(7.7f);
		bs.setUnitValue(1.8f);
		
		String currentAirDensity = measurementCoprocessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("failed")));
	}

}
