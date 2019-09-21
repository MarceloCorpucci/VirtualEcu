package virtualecu.core.processor;

import java.util.Map;

import virtualecu.core.processor.instruction.RpmConfig;
import virtualecu.core.processor.instruction.RpmConfigMap;

public class CalculationCoprocessor extends EcuProcessor {
	//TODO this class needs to be refactored once the calculation shows the proper rpm scale.
	private RpmConfigMap rpmConfigMap = new RpmConfigMap();
	
	public int showRpm() {
		int[] ckpRange = ckp.getInterrupterRingSpecs();
		float multiplier = ckp.getUnitValue();
		Map<Integer, RpmConfig> standardMap = rpmConfigMap.getStandardMap();
		float rpm = 0.0f;

		RpmConfig rpmConfig = new RpmConfig();
		int tpsAngle = (int)tps.getUnitValue();
		rpmConfig = standardMap.get(tpsAngle);
		float subtotal = 0.0f;
		float total = 0.0f;
		for(float volt : ckpRange) {
			if (volt == 1) {
				subtotal = tpsAngle / rpmConfig.getParam1();
				total = subtotal + rpmConfig.getParam2(); 
				rpm = ((total + multiplier) * 9) * rpmConfig.getParam3();
//				rpm *= multiplier;
				}
			}
			
		return Math.round(rpm);
		}
	
	}