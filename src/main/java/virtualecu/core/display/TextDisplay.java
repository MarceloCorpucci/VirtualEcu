package virtualecu.core.display;

import virtualecu.core.interfaces.DisplayPort;
import virtualecu.core.interfaces.Displayable;

public class TextDisplay implements Displayable {
	private DisplayPort displayPort;
//	
//	public void connectToDisplayPort(DisplayPort displayPort) {
//		this.displayPort = displayPort;
//	}
	public TextDisplay() {
		this.displayPort = new DisplayPort();
	}
	
	public void connectToBusses() {
		displayPort.connectToInputBus();
		displayPort.connectToMainBus();
		displayPort.connectToOutputBus();
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}

	public void showRPMs() {
//		String[] params = displayPort.composeInformationAboutRpms();
//		System.out.println(
//						params[0] + ": " + 
//						params[1] + 
//						params[2] + " @ " + 
//						params[3] + "rpm.");
	}

	public void standardMessage(String[] params) {
		System.out.println(
						params[0] + ": " +
						params[1] + 
						params[2]);
		
	}

	public void showAirFuelRatio(String[] params) {
		System.out.println(
						params[0] + ": is receiving " + 
						params[1] + " air/fuel ratio - " + 
						params[2]);
	}
}
