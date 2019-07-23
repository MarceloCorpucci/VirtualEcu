package virtualecu.core.bus;

import virtualecu.core.output.FuelInjector;
import virtualecu.core.output.FuelPump;
import virtualecu.core.output.IgnitionControlModule;

public class OutputBus {
	private FuelPump fuelPump;
	private FuelInjector injector;
	private IgnitionControlModule ignitionModule;
	
	public OutputBus() {
		fuelPump = new FuelPump();
		injector = new FuelInjector(true);
		ignitionModule = new IgnitionControlModule();
	}
	
	public FuelPump connectFuelPump() {
		return fuelPump;
	}
	
	public FuelInjector prepareInjectors() {
		return injector;
	}
	
	public IgnitionControlModule prepareIgnitionModule() {
		return ignitionModule;
	}
	
	public String getFuelPumpState() {
		return fuelPump.getFuelPumpState();
	}
}
