package virtualecu.core.processor;

public class CalculationCoprocessor extends EcuProcessor {
	
	public int showRpm() {
		int[] range = ckp.getInterrupterRingSpecs();
		float multiplier = ckp.getVoltage();
		for(float volt : range) {
			if (volt == 1) {
				multiplier *= 2.02;
			}
		}
		return Math.round(multiplier);
	}
	
}
