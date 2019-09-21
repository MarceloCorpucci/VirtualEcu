package virtualecu.core.interfaces;

import virtualecu.core.bus.InputBus;
import virtualecu.core.bus.MainBus;
import virtualecu.core.bus.OutputBus;

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
		
		String message = "VirtualEcu started!\n===================";
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive(message).showSimpleMessage();
	}
	
	public void informRpms() {
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		
		mainBus.toDisplayPort().communicateWithInputBus(inputBus);
		mainBus.toDisplayPort().communicateWithMainBus(mainBus);
		
		String[] message = mainBus.toDisplayPort().composeInfoAboutRpms();
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive(message).showRpms();
	}
	
	public String[] informRpms(float tpsAngle) {
		this.connectToInputBus();
		this.connectToMainBus();
		
		mainBus.toCalculationCoprocessor().setTps(inputBus.manageTPS(tpsAngle));
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		
		mainBus.toDisplayPort().communicateWithInputBus(inputBus);
		mainBus.toDisplayPort().communicateWithMainBus(mainBus);
		return mainBus.toDisplayPort().composeInfoAboutRpms();
	}
	
	public void informAirPressure(float mapAirPressure, float bsAirPressure) {
		inputBus.manageMAP(mapAirPressure);
		inputBus.manageBS(bsAirPressure);

		mainBus.toDisplayPort().communicateWithInputBus(inputBus);
		String[] message = mainBus.toDisplayPort().composeInfoAboutAirPressure();
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive(message).showAirAirPressure();
	}
	
	public void informEngineTemp(float temp) {
		mainBus.toCalculationCoprocessor().setEct(inputBus.manageECT(temp));
	
		mainBus.toDisplayPort().communicateWithMainBus(mainBus);
		
		String[] message = mainBus.toDisplayPort().composeInfoAboutEngineTemp();
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive(message).showStandardMessage();
	}
	
	public void measureAirDensity(float airTemp, float mapAirPressure, float bsAirPressure){
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		mainBus.toCalculationCoprocessor().setEct(inputBus.manageECT(airTemp));
		
		String message = mainBus.toMeasurementCoprocessor().measureAirDensity(inputBus.manageMAP(mapAirPressure), inputBus.manageBS(bsAirPressure));
		
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive("Air Density Level: " + message).showSimpleMessage();
	}
	
//	public void accelerate() {
//		String airDensity = mainBus.toMeasurementCoprocessor().measureAirDensity(inputBus.manageMAP(2.7f), inputBus.manageBS(2.4f));
//		mainBus.toInjectionCoprocessor().setCkp(inputBus.manageCKP());
//		mainBus.toInjectionCoprocessor().setEct(inputBus.manageECT(25.3f));
//		mainBus.toInjectionCoprocessor().dosifyFuel(inputBus.manageTPS(40), airDensity);
//		
////		TextDisplay.showMessage(mainBus.toInjectionCoprocessor().getInjectorState());
////		TextDisplay.showMessage(mainBus.toInjectionCoprocessor().getIgnitionState());
//	}
	
	public void measureAirFuelRatio(float airFuelRatio) {
		inputBus.manageLambda(airFuelRatio);
		mainBus.toDisplayPort().communicateWithInputBus(inputBus);
		String[] message = mainBus.toDisplayPort().composeInfoAboutAirFuelRatio(airFuelRatio);
		mainBus.toDisplayPort().sendSignalToDisplayableDevice().receive(message).showAirFuelRatio();
	}
}
