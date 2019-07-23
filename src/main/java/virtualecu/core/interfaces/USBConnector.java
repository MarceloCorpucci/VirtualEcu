package virtualecu.core.interfaces;

import virtualecu.core.bus.InputBus;
import virtualecu.core.bus.MainBus;
import virtualecu.core.bus.OutputBus;
import virtualecu.core.display.EcuDashboard;

public class USBConnector implements Pluggable {
	private MainBus mainBus;
	private InputBus inputBus;
	private OutputBus outputBus;
	
	public void connectToMainBus() {
		mainBus = new MainBus();
	}

	public void connectToInputBus() {
		inputBus = new InputBus();
	}
	
	public void connectToOutputBus() {
		outputBus = new OutputBus();
	}

	public void startEcu() {
		mainBus.toInjectionCoprocessor().setFuelPump(outputBus.connectFuelPump());
		mainBus.toInjectionCoprocessor().activateFuelPump();

		mainBus.toInjectionCoprocessor().setInjector(outputBus.prepareInjectors());
		mainBus.toInjectionCoprocessor().setIgnitionModule(outputBus.prepareIgnitionModule());
	}
	
	public void getRpms() {
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		EcuDashboard.showMessage(
						inputBus.ckpName() + ": " + 
						inputBus.ckpValue() + 
						inputBus.ckpMeasurementUnit() + " @ " + 
						Integer.toString(mainBus.toCalculationCoprocessor().showRpm()) + "rpm.");
	}
	
	public void showAirPressure() {
		inputBus.manageMAP(2.7f);
		inputBus.manageBS(2.4f);
		
		EcuDashboard.showMessage(
						inputBus.mapName() + ": " +
						inputBus.mapValue() + "Hg");
		
		EcuDashboard.showMessage(
						inputBus.bsName() + ": " +
						inputBus.bsValue() + 
						inputBus.bsMeasurementUnit());
		
	}
	
	public void showEngineTemp() {
		mainBus.toCalculationCoprocessor().setEct(inputBus.manageECT(25.3f));
		
		EcuDashboard.showMessage(
				inputBus.ectName() + ": " +
				inputBus.ectValue() + 
				inputBus.ectMeasurementUnit());
	}
	
	public void measureAirDensity(){
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		mainBus.toCalculationCoprocessor().setEct(inputBus.manageECT(25.3f));
		
		String airDensity = mainBus.toMeasurementCoprocessor().measureAirDensity(inputBus.manageMAP(2.7f), inputBus.manageBS(2.4f));
				
		EcuDashboard.showMessage("Air Density Level: " + airDensity);

	}
	
	public void accelerate() {
		String airDensity = mainBus.toMeasurementCoprocessor().measureAirDensity(inputBus.manageMAP(2.7f), inputBus.manageBS(2.4f));
		mainBus.toInjectionCoprocessor().setCkp(inputBus.manageCKP());
		mainBus.toInjectionCoprocessor().setEct(inputBus.manageECT(25.3f));
		mainBus.toInjectionCoprocessor().dosifyFuel(inputBus.manageTPS(40), airDensity);
		
		EcuDashboard.showMessage(mainBus.toInjectionCoprocessor().getInjectorState());
		EcuDashboard.showMessage(mainBus.toInjectionCoprocessor().getIgnitionState());
	}
	
	public void measureAirFuelRatio() {
		float airFuelRatio = 11.5f;
		inputBus.manageLambda(11.5f);
		inputBus.manageLambda(airFuelRatio);
		
		EcuDashboard.showMessage(inputBus.lambdaName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + inputBus.lambdaState()); 
	}
}
