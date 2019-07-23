package virtualecu.core.runner;

import virtualecu.core.interfaces.Pluggable;
import virtualecu.core.interfaces.USBConnector;

public class EcuRunner {
	public static void main (String[] args) {		
		Pluggable usbConnector = new USBConnector();
		usbConnector.connectToInputBus();
		usbConnector.connectToMainBus();
		usbConnector.connectToOutputBus();
		
		usbConnector.startEcu();
		usbConnector.getRpms();
		usbConnector.showAirPressure();
		usbConnector.showEngineTemp();
		usbConnector.measureAirDensity();
		usbConnector.accelerate();
		usbConnector.measureAirFuelRatio();
	}

}
