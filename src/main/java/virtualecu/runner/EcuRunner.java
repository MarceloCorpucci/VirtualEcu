package virtualecu.runner;

import virtualecu.display.EcuDashboard;
import virtualecu.input.CKP;
import virtualecu.input.ECT;
import virtualecu.input.TPS;

public class EcuRunner {
	public static void main (String[] args) {
		final String description = "====== Virtual ECU runner ======";
		
		EcuDashboard dashboard = new EcuDashboard();
		CKP ckp = new CKP();
		TPS tps = new TPS();
		ECT ect = new ECT();

		System.out.println(description);
		
		dashboard.message = "Crankshaft Position Sensor: ";
		ckp.voltage = 5.0f;
		System.out.println(dashboard.message + ckp.voltage + "v");
		
		dashboard.message = "throttle position: ";
		tps.angle = 40;
		System.out.println(dashboard.message + tps.angle + "º");
		
		ect.temperature = 65.3f;
		dashboard.message = "engine temperature: ";
		System.out.println("Engine temperature: " + ect.temperature + "º");
	}

}
