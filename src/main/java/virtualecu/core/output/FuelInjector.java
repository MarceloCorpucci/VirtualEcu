package virtualecu.core.output;

public class FuelInjector {
	private boolean voltageOn;
	private String state;
	
	public FuelInjector(boolean voltageOn) {
		this.voltageOn = voltageOn;
		state = "fuel injector closed";
	}
	
	public void interruptVoltage() {
		voltageOn = false;
	}
	
	public void inject(float pressure) {
		if (voltageOn == false) {
			if (pressure <= 2.5f) {
				state = "injecting fuel";
			} else {
				state = "injecting fuel, full capacity";
			}
		}
	}
	
	public String getState() {
		return state;
	}
}
