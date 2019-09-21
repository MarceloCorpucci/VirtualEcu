package virtualecu.core.processor;

import virtualecu.core.input.CKP;
import virtualecu.core.input.ECT;
import virtualecu.core.input.TPS;
import virtualecu.core.output.FuelInjector;
import virtualecu.core.output.FuelPump;
import virtualecu.core.output.IgnitionControlModule;

public class EcuProcessor {
	protected FuelPump fuelPump;
	protected FuelInjector injector;
	protected IgnitionControlModule ignitionModule;
	protected TPS tps;
	protected ECT ect;
	protected CKP ckp;

	public FuelPump getFuelPump() {
		return fuelPump;
	}

	public void setFuelPump(FuelPump fuelPump) {
		this.fuelPump = fuelPump;
	}

	public FuelInjector getInjector() {
		return injector;
	}

	public void setInjector(FuelInjector injector) {
		this.injector = injector;
	}

	public IgnitionControlModule getIgnitionModule() {
		return ignitionModule;
	}

	public void setIgnitionModule(IgnitionControlModule ignitionModule) {
		this.ignitionModule = ignitionModule;
	}
	
	public TPS getTps() {
		return tps;
	}
	
	public void setTps(TPS tps) {
		this.tps = tps;
	}
	
	public ECT getEct() {
		return ect;
	}

	public void setEct(ECT ect) {
		this.ect = ect;
	}
	
	public CKP getCkp() {
		return ckp;
	}

	public void setCkp(CKP ckp) {
		this.ckp = ckp;
	}

}
