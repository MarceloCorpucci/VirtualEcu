package virtualecu.core.runner;

import virtualecu.core.display.EcuDashboard;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.TPS;

public class EcuRunner {
	public static void main (String[] args) {
		final String description = "====== Virtual ECU runner ======";
		
		boolean isCelsius = true;
		CKP ckp = new CKP();
		ECT ect = new ECT(isCelsius);
		TPS tps = new TPS();

		EcuDashboard.showMessage(description);
		
		ckp.setVoltage(5.0f);
		EcuDashboard.showMessage(ckp.getName() + ": " + ckp.getVoltage() + "v");
				
		tps.setAngle(40);
		EcuDashboard.showMessage(tps.getName() + ": " + tps.getAngle() + "º");
		
		ect.setTemperature(65.3f);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");
	}

}
