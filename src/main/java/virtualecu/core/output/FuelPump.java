package virtualecu.core.output;

public class FuelPump {
	private boolean isWorking;
	
	public FuelPump() {
		isWorking = false;
	}
	
	public void activate() {
		isWorking = true;
	}
	
	public String getFuelPumpState() {
		String message = "Fuel Pump deactivated.";
		
		if (isWorking) {
			message = "Fuel Pump activated.";
		}
		
		return message;
	}

}
