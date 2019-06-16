package virtualecu.core.input;

public class ECT {
	private String name;
	private boolean isCelsius;
	private float temperature;
	
	public ECT(boolean isCelsius) {
		this.name = "Engine Coolant Temperature Sensor";
		this.isCelsius = isCelsius;
	}

	public String getName() {
		return name;
	}
	
	public boolean isCelsius() {
		return this.isCelsius;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

}
