package virtualecu.core.input;

public class CKP {
	private String name;
	private float voltage;
	private int[] interrupterRing = {1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
	
	public CKP() {
		name = "Crankshaft Position Sensor";
		voltage = 0;
	}

	public String getName() {
		return name;
	}

	public float getVoltage() {
		return Math.round(voltage * 100.0) / 100.0f;
	}

	public int[] getInterrupterRingSpecs() {
		return interrupterRing;
	}
	
	public void setVoltage() {
		for (int slot : interrupterRing) {
			if (slot != 0) {
				voltage += 0.15f;
			}
		}
	}
	
}
