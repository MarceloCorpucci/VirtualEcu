package virtualecu.core.processor;

import virtualecu.core.input.BS;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;
import virtualecu.core.output.FuelInjector;
import virtualecu.core.processor.instruction.FuelDosis;

public class EcuProcessor {
	private boolean voltageOn = true;		
	private FuelInjector injector = new FuelInjector(voltageOn);
	private String airDensity;
	
	public String measureAirDensity(MAP map, BS bs) {
		int airDensityDiff = Math.round(map.getHg() - bs.getHg());
		
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
	
	public void dosifyFuel(TPS tps) {
		switch(airDensity) {
		case "low":
			if (tps.getAngle() >= 50) {
				injectFuel(FuelDosis.STAGE_O);
			} else {
				injectFuel(FuelDosis.STAGE_O + 0.3f);
			}
			break;
		case "normal":
			if (tps.getAngle() >= 50) {
				injectFuel(FuelDosis.STAGE_1);
			} else {
				injectFuel(FuelDosis.STAGE_1 + 0.4f);
			}
			break;
		case "high":
			if (tps.getAngle() >= 50) {
				injectFuel(FuelDosis.STAGE_2);
			} else {
				injectFuel(FuelDosis.STAGE_3);
			}
		default:
			//todo set injector closed.
		}
	}
	
	public String getInjectorState() {
		return injector.getState();
	}
	
	private void injectFuel(float fuelDosis) {
		injector.interruptVoltage();
		injector.inject(fuelDosis);
	}
}
