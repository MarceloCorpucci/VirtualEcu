package virtualecu.core.input;

public class Lambda {
	private String name;
	private String state;
	
	public Lambda() {
		name = "Wide Band Oxygen Sensor";
	}
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return state;
	}
	
	public void measureRatio(float airFuelRatio) {
		if (airFuelRatio <= 14.5f) {
			state = "Rich Mixture";
		} else {
			state = "Lean Mixture";
		}
	}
}
