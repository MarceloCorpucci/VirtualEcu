package virtualecu.core.input;

public class Lambda {
	private String name;
	private String measurementResult;
	private String temperatureState;
	int seconds;
	
	public Lambda() {
		name = "Wide Band Oxygen Sensor";
		seconds = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return temperatureState + measurementResult;
	}
	
	public void measureRatio(float airFuelRatio) {
		heatSensor();

		if (airFuelRatio <= 14.5f) {
			measurementResult = "Rich Mixture";
		} else {
			measurementResult = "Lean Mixture";
		}
	}
	
	public void heatSensor() {
		temperatureState = "";
		while(seconds < 30) {
			temperatureState = "Heating sensor. ";
			seconds++;
		}
	}
}
