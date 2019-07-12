package virtualecu.core.input;

public class InputSensor {
	private String name;
	private String measurementUnit;
	private float unitValue;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	
	public float getUnitValue() {
		return unitValue;
	}
	
	public void setUnitValue(float unitValue) {
		this.unitValue = unitValue;
	}
}
