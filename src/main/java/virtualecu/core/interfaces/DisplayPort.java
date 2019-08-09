package virtualecu.core.interfaces;

import virtualecu.core.bus.InputBus;
import virtualecu.core.bus.MainBus;
import virtualecu.core.bus.OutputBus;

public class DisplayPort {
	private InputBus inputBus;
	private MainBus mainBus;
	private OutputBus outputBus;

	public void connectToInputBus() {
		this.inputBus = new InputBus();
	}

	public void connectToMainBus() {
		this.mainBus = new MainBus();
	}

	public void connectToOutputBus() {
		this.outputBus = new OutputBus();
	}

	public String[] composeInfoAboutRpms() {
		mainBus.toCalculationCoprocessor().setCkp(inputBus.manageCKP());
		
		String[] params = new String[4];
		params[0] = inputBus.ckpName();
		params[1] = Float.toString(inputBus.ckpValue());
		params[2] = inputBus.ckpMeasurementUnit();
		params[3] = Integer.toString(mainBus.toCalculationCoprocessor().showRpm());
		
		return params;
	}
	
	public String[] composeInfoAirPressure() {
		String[] params = new String[4];
		
		inputBus.manageMAP(2.7f);
		inputBus.manageBS(2.4f);
//		
//		TextDisplay.showMessage(
//						inputBus.mapName() + ": " +
//						inputBus.mapValue() + "Hg");
//		
//		TextDisplay.showMessage(
//						inputBus.bsName() + ": " +
//						inputBus.bsValue() + 
//						inputBus.bsMeasurementUnit());
		
		return params;
	}
}
