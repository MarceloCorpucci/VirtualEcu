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
			switch(Math.round(pressure)) {
			case 1:
				state = "injecting fuel, efficiency mode";
				break;
			case 2:
				state = "injecting fuel, normal mode";
				break;
			case 3: 
				state = "injecting fuel, full capacity";
			}
		}
	}
	
	public String getState() {
		return state;
	}
}
