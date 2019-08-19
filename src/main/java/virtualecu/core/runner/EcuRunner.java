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
		usbConnector.informRpms();
		
		usbConnector.informAirPressure(2.7f, 2.4f);
		usbConnector.informEngineTemp(25.3f);
		usbConnector.measureAirDensity(25.3f, 2.7f, 2.4f);
//		usbConnector.accelerate();
		usbConnector.measureAirFuelRatio(11.5f);
	}

}
