package virtualecu.core.interfaces;

import virtualecu.core.bus.InputBus;
import virtualecu.core.bus.MainBus;
import virtualecu.core.display.TextDisplay;

public class DisplayPort {
	private InputBus inputBus;
	private MainBus mainBus;
	private Displayable device;
	
	public DisplayPort() {
		this.device = new TextDisplay();
	}
	
	public void communicateWithInputBus(InputBus inputBus) {
		this.inputBus = inputBus;
	}
	
	public void communicateWithMainBus(MainBus mainBus) {
		this.mainBus = mainBus;
	}	
	
	public Displayable sendSignalToDisplayableDevice() {
		return device;
	}
	
	public String[] composeInfoAboutRpms() {
//		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		
		String[] params = new String[4];
		params[0] = inputBus.ckpName();
		params[1] = Float.toString(inputBus.ckpValue());
		params[2] = inputBus.ckpMeasurementUnit();
		params[3] = Integer.toString(mainBus.toCalculationCoprocessor().showRpm());
		
		return params;
	}
	
	public String[] composeInfoAboutAirPressure() {
		String[] params = new String[5];
		
		params[0] = inputBus.mapName();
		params[1] = Float.toString(inputBus.mapValue());
		params[2] = inputBus.bsName();
		params[3] = Float.toString(inputBus.bsValue());
		params[4] = inputBus.bsMeasurementUnit();
		
		return params;
	}
	
	public String[] composeInfoAboutEngineTemp() {
		String[] params = new String[3];

		params[0] = inputBus.ectName();
		params[1] = Float.toString(inputBus.ectValue());
		params[2] = inputBus.ectMeasurementUnit();

		return params;
	}

	public String[] composeInfoAboutAirFuelRatio(float airFuelRatio) {
		//TextDisplay.showMessage(inputBus.lambdaName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + inputBus.lambdaState());
		String[] params = new String[3];
		params[0] = inputBus.lambdaName();
		params[1] = Float.toString(airFuelRatio);
		params[2] = inputBus.lambdaState();
		return params;
	}
}
