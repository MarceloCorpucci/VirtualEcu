package virtualecu.core.input;

public class TPS {
	private String name;
	private int angle;
	
	public TPS() {
		name = "Throttle Position Sensor";
	}

	public String getName() {
		return name;
	}
	
	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}
}
