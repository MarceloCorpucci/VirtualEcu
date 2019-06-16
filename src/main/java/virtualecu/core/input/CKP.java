package virtualecu.core.input;

public class CKP {
	private String name;
	public float voltage;
	
	public CKP() {
		name = "Crankshaft Position Sensor";
	}

	public String getName() {
		return name;
	}

	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
}
