package virtualecu.core.runner;

import virtualecu.core.display.EcuDashboard;
import virtualecu.core.input.BS;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.Lambda;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;
import virtualecu.core.output.FuelInjector;
import virtualecu.core.output.FuelPump;
import virtualecu.core.output.IgnitionControlModule;
import virtualecu.core.processor.CalculationCoprocessor;
import virtualecu.core.processor.InjectionCoprocessor;
import virtualecu.core.processor.MeasurementCoprocessor;

public class EcuRunner {
	public static void main (String[] args) {
		final String description = "====== Virtual ECU runner ======";
		
		FuelPump fuelPump = new FuelPump();
		Lambda lambda = new Lambda();
		boolean voltageOn = true;
		FuelInjector injector = new FuelInjector(voltageOn);
		IgnitionControlModule ignitionModule = new IgnitionControlModule();
		boolean isCelsius = true;
		CKP ckp = new CKP();
		ECT ect = new ECT(isCelsius);
		TPS tps = new TPS();
		MAP map = new MAP();
		BS bs = new BS();

		InjectionCoprocessor injectionCoprocessor = new InjectionCoprocessor();
		CalculationCoprocessor calculationCoprocessor = new CalculationCoprocessor();
		MeasurementCoprocessor measurementCoprocessor = new MeasurementCoprocessor();

		EcuDashboard.showMessage(description);
		
		injectionCoprocessor.setFuelPump(fuelPump);
		injectionCoprocessor.activateFuelPump();
		EcuDashboard.showMessage(injectionCoprocessor.getFuelPumpState());
		
		injectionCoprocessor.setInjector(injector);
		injectionCoprocessor.setIgnitionModule(ignitionModule);
		
		ckp.setUnitValue();
		calculationCoprocessor.setCkp(ckp);
		EcuDashboard.showMessage(ckp.getName() + ": " + ckp.getUnitValue() + ckp.getMeasurementUnit() + " @ " + Integer.toString(calculationCoprocessor.showRpm()) + "rpm.");
				
		map.setHg(2.7f);
		EcuDashboard.showMessage(map.getName() + ": " + map.getHg() + "Hg");

		bs.setHg(2.4f);
		EcuDashboard.showMessage(bs.getName() + ": " + bs.getHg() + "Hg");
		
		ect.setTemperature(25.3f);
		measurementCoprocessor.setEct(ect);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");

		tps.setAngle(40);
		injectionCoprocessor.setCkp(ckp);
		injectionCoprocessor.setEct(ect);
		String airDensity = measurementCoprocessor.measureAirDensity(map, bs);
		EcuDashboard.showMessage("Air Density Level: " + airDensity);
		injectionCoprocessor.dosifyFuel(tps, airDensity);
		EcuDashboard.showMessage(tps.getName() + ": " + tps.getAngle() + "º");
		EcuDashboard.showMessage(injectionCoprocessor.getInjectorState());
		EcuDashboard.showMessage(injectionCoprocessor.getIgnitionState());
		EcuDashboard.showMessage(measurementCoprocessor.checkCoolantTemperature());
		
		float airFuelRatio = 11.5f;
		lambda.measureRatio(airFuelRatio);
		EcuDashboard.showMessage(lambda.getName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + lambda.getState());
	}

}