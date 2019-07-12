package virtualecu.core.input;

public class ECT extends InputSensor {
	private boolean isCelsius;
	
	public ECT(boolean isCelsius) {
		this.isCelsius = isCelsius;
		this.setName("Engine Coolant Temperature Sensor");
		this.setMeasurementUnit("Hg");
	}
	
	public boolean isCelsius() {
		return this.isCelsius;
	}

}
