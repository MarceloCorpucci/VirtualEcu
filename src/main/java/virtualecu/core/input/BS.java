package virtualecu.core.input;

public class BS {
	private String name;
	private float hg;
	
	public BS() {
		this.name = "Barometric Sensor";
	}

	public String getName() {
		return name;
	}
	
	public float getHg() {
		return hg;
	}

	public void setHg(float hg) {
		this.hg = hg;
	}
}
