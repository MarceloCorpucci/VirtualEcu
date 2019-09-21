package virtualecu.core.processor.instruction;

import java.util.HashMap;
import java.util.Map;

public class RpmConfigMap {
	private int id;
	private int param1;
	private float param2;
	private int param3;
	private RpmConfig rpmConfig;
	private Map<Integer, RpmConfig> configMap;
	
	public RpmConfigMap() {
		configMap = new HashMap<>();
		param1 = 20;
		param2 = 0.02f;
		param3 = 25;
	}

	public Map<Integer, RpmConfig> getStandardMap() {
		for(int i = 40; i <= 90; i++) {
			rpmConfig = new RpmConfig();
			
			if(id==40) {
				rpmConfig.setParam1(param1);
				rpmConfig.setParam2(param2);
				rpmConfig.setParam3(param3);
			} else {
				if(id==41) {
					param2 = -0.02f;
				} else {
					param2 += -0.04f;
				}
				param3 += 4;
				rpmConfig.setParam1(param1);
				rpmConfig.setParam2(param2);
				rpmConfig.setParam3(param3);
			}
			
			configMap.put(i,rpmConfig);
		}
		return configMap;
	}
}
