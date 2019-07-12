package virtualecu.core.input;

public class MAP {
	private String name;
	private float hg;
	
	public MAP() {
		this.name = "Manifold Absolute Pressure Sensor";
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
