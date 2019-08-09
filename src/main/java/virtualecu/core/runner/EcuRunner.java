package virtualecu.core.runner;

import virtualecu.core.display.TextDisplay;
import virtualecu.core.interfaces.Pluggable;
import virtualecu.core.interfaces.USBConnector;

public class EcuRunner {
	public static void main (String[] args) {		
		Pluggable usbConnector = new USBConnector();
		TextDisplay textDisplay = new TextDisplay();
		
		usbConnector.connectToInputBus();
		usbConnector.connectToMainBus();
		usbConnector.connectToOutputBus();
		
		textDisplay.connectToBusses();
		
		usbConnector.startEcu();
//		usbConnector.getRpms();
		textDisplay.showRPMs();
		
		usbConnector.showAirPressure();
		usbConnector.showEngineTemp();
		usbConnector.measureAirDensity();
		usbConnector.accelerate();
		usbConnector.measureAirFuelRatio();
	}

}
