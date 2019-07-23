package virtualecu.core.bus;

import virtualecu.core.input.BS;
import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.Lambda;
import virtualecu.core.input.MAP;
import virtualecu.core.input.TPS;

public class InputBus {
	private BS bs;
	private CKP ckp;
	private ECT ect;
	private Lambda lambda;
	private MAP map;
	private TPS tps;
	
	public InputBus() {
		bs = new BS();
		ckp = new CKP();
		ect = new ECT(true);
		lambda = new Lambda();
		map = new MAP();
		tps = new TPS();
	}
	
	public BS manageBS(float unitValue) {
		bs.setUnitValue(unitValue);
		return bs;
	}

	public String bsName() {
		return bs.getName();
	}
	
	public String bsMeasurementUnit() {
		return bs.getMeasurementUnit();
	}
	
	public float bsValue() {
		return bs.getUnitValue();
	}	
	
	public CKP manageCKP() {
		ckp.setUnitValue();
		return ckp;
	}
	
	public String ckpName() {
		return ckp.getName();
	}
	
	public String ckpMeasurementUnit() {
		return ckp.getMeasurementUnit();
	}
	
	public float ckpValue() {
		return ckp.getUnitValue();
	}
	
	public ECT manageECT(float unitValue) {
		ect.setUnitValue(unitValue);
		return ect;
	}
	
	public String ectName() {
		return ect.getName();
	}
	
	public String ectMeasurementUnit() {
		return ect.getMeasurementUnit();
	}
	
	public float ectValue() {
		return ect.getUnitValue();
	}
	
	public Lambda manageLambda(float airFuelRatio) {
		lambda.measureRatio(airFuelRatio);
		return lambda;
	}
	
	public String lambdaName() {
		return lambda.getName();
	}
	
	public String lambdaState() {
		return lambda.getState();
	}
	
	public MAP manageMAP(float unitValue) {
		map.setUnitValue(unitValue);
		return map;
	}
	
	public String mapName() {
		return map.getName();
	}
	
	public String mapMeasurementUnit() {
		return map.getMeasurementUnit();
	}
	
	public float mapValue() {
		return map.getUnitValue();
	}
	
	public TPS manageTPS(float unitValue) {
		tps.setUnitValue(unitValue);
		return tps;
	}
}
