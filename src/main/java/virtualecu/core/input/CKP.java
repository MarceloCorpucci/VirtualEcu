package virtualecu.core.input;

public class CKP extends InputSensor {
	private float voltage;
	private int[] interrupterRing = {1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
	
	public CKP() {
		this.setName("Crankshaft Position Sensor");
		this.setMeasurementUnit("v");
		voltage = 0;
	}

	
	public float getUnitValue() {
		return Math.round(voltage * 100.0) / 100.0f;
	}
	
	public void setUnitValue() {
		for (int slot : interrupterRing) {
			if (slot != 0) {
				voltage += 0.15f;
			}
		}
	}

	public int[] getInterrupterRingSpecs() {
		return interrupterRing;
	}
	
}
