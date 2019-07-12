package virtualecu.core.processor;

import virtualecu.core.input.BS;
import virtualecu.core.input.MAP;
import virtualecu.core.processor.instruction.TemperatureThreshold;

public class MeasurementCoprocessor extends EcuProcessor {
	
	public String checkCoolantTemperature() {
		String message =  "";
		int indexFromEct = Math.round(ect.getTemperature());
		int times = 0;
		
		if(ect.getTemperature() < TemperatureThreshold.MIN_CELSIUS) {
			
			for(int i = indexFromEct; i < TemperatureThreshold.MIN_CELSIUS; i++) {
				times += 1;
			}
			
			if(indexFromEct + times == Math.round(TemperatureThreshold.MIN_CELSIUS) + 1) message = "Checking coolant temp, reaching minimum threshold in " + times + " secs";
			
		} else {
			for(int i = indexFromEct; i < TemperatureThreshold.MAX_CELSIUS; i++) {
				times += 1;
			}	
			
			if(indexFromEct + times == Math.round(TemperatureThreshold.MAX_CELSIUS) + 1) message = "Checking coolant temp, reaching max threshold in " + times + " secs";
		}
		return message;
	}

	public String measureAirDensity(MAP map, BS bs) {
		int airDensityDiff = Math.round(map.getHg() - bs.getHg());
		String airDensity = "not determined";
		
		switch (airDensityDiff) {
		case 0: case 1:
			airDensity = "low";
			break;
		case 2: case 3:
			airDensity = "normal";
			break;
		case 4:
			airDensity = "high";
			break;
		default:
			airDensity = "failed";
		}
		
		return airDensity;
	}
	
}