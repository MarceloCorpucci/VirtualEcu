package virtualecu.core.processor;

import virtualecu.core.input.TPS;
import virtualecu.core.processor.instruction.FuelDosis;

public class InjectionCoprocessor extends EcuProcessor {
	
	public void activateFuelPump() {
		fuelPump.activate();
	}
	
	public String getFuelPumpState() {
		return fuelPump.getFuelPumpState();
	}
	
	public void dosifyFuel(TPS tps, String airDensity) {
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
	
	private void injectFuel(float fuelDosis) {
		injector.interruptVoltage();
		injector.inject(fuelDosis);
		
		int pulse = 1;
		int i = 1;
		int[] range = ckp.getInterrupterRingSpecs();
		while (pulse == range[i]) {
			ignitionModule.ignite();
			i++;
		}
		
		float coolantTemp = ect.getTemperature();
		if(fuelDosis >= FuelDosis.STAGE_O && fuelDosis <= FuelDosis.STAGE_1) ect.setTemperature(coolantTemp + 50.2f);
		if(fuelDosis >= FuelDosis.STAGE_2 && fuelDosis <= FuelDosis.STAGE_3) ect.setTemperature(coolantTemp + 55.6f);
	}
	
	public String getInjectorState() {
		return injector.getState();
	}

	public String getIgnitionState() {
		return ignitionModule.getIgnitionCoilState();
	}
}