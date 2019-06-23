package virtualecu.core.runner;

import virtualecu.core.display.EcuDashboard;
import virtualecu.core.input.BS;
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
		BS bs = new BS();
		Lambda lambda = new Lambda();
		EcuProcessor processor = new EcuProcessor();

		EcuDashboard.showMessage(description);
		
		ckp.setVoltage();
		processor.setCkp(ckp);
		EcuDashboard.showMessage(ckp.getName() + ": " + ckp.getVoltage() + "v " + "@ " + Integer.toString(processor.showRpm()) + "rpm.");
				
		map.setHg(2.7f);
		EcuDashboard.showMessage(map.getName() + ": " + map.getHg() + "Hg");

		bs.setHg(2.4f);
		EcuDashboard.showMessage(bs.getName() + ": " + bs.getHg() + "Hg");
		
		ect.setTemperature(25.3f);
		processor.setEct(ect);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");

		tps.setAngle(40);
		String airDensity = processor.measureAirDensity(map, bs);
		EcuDashboard.showMessage("Air Density Level: " + airDensity);
		processor.dosifyFuel(tps);
		EcuDashboard.showMessage(tps.getName() + ": " + tps.getAngle() + "º");
		EcuDashboard.showMessage(processor.getInjectorState());
		EcuDashboard.showMessage(processor.checkCoolantTemperature());
		
		float airFuelRatio = 11.5f;
		lambda.measureRatio(airFuelRatio);
		EcuDashboard.showMessage(lambda.getName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + lambda.getState());
	}

}
