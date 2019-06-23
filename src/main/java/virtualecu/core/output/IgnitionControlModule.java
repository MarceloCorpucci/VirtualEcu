package virtualecu.core.output;

public class IgnitionControlModule {
	private String ignitionState;
	
	public IgnitionControlModule() {
		ignitionState = "ignition coil deactivated.";
	}
	
	public void ignite() {
		ignitionState = "ignition coil activated.";
	}
	
	public String getIgnitionCoilState() {
		return ignitionState;
	}
}
