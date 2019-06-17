package virtualecu.core.runner;

import virtualecu.core.display.EcuDashboard;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.Lambda;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;
import virtualecu.core.processor.EcuProcessor;

public class EcuRunner {
	public static void main (String[] args) {
		final String description = "====== Virtual ECU runner ======";
		
		boolean isCelsius = true;
		CKP ckp = new CKP();
		ECT ect = new ECT(isCelsius);
		TPS tps = new TPS();
		MAP map = new MAP();
		Lambda lambda = new Lambda();
		EcuProcessor processor = new EcuProcessor();

		EcuDashboard.showMessage(description);
		
		ckp.setVoltage(5.0f);
		EcuDashboard.showMessage(ckp.getName() + ": " + ckp.getVoltage() + "v");
				
		tps.setAngle(40);
		processor.dosifyFuel(tps);
		EcuDashboard.showMessage(tps.getName() + ": " + tps.getAngle() + "º");
		EcuDashboard.showMessage(processor.getInjectorState());
		
		ect.setTemperature(65.3f);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");
		
		map.setHg(2.5f);
		EcuDashboard.showMessage(map.getName() + ": " + map.getHg() + "Hg");
		
		float airFuelRatio = 11.5f;
		lambda.measureRatio(airFuelRatio);
		EcuDashboard.showMessage(lambda.getName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + lambda.getState());
	}

}
