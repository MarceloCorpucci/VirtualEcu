package virtualecu.core.display;

import virtualecu.core.interfaces.Displayable;

public class TextDisplay implements Displayable {
	private String[] message;
	private String simpleMessage;
	
	public Displayable receive(String[] message) {
		this.message = message;
		return this;
	}

	public Displayable receive(String message) {
		this.simpleMessage = message;
		return this;
	}
	
	public void showSimpleMessage() {
		System.out.println(simpleMessage);
	}

	public void showRpms() {
		System.out.println(
				message[0] + ": " + 
				message[1] + 
				message[2] + " @ " + 
				message[3] + "rpm.");
	}

	public void showAirAirPressure() {
		System.out.println(
				message[0] + ": " + 
				message[1] + "Hg | " +
				message[2] + ": " +
				message[3] + 
				message[4]);
	}
	
	public void showStandardMessage() {
		System.out.println(
						message[0] + ": " +
						message[1] + 
						message[2]);
		
	}

	public void showAirFuelRatio() {
		System.out.println(
						message[0] + ": is receiving " + 
						message[1] + " " +
						"air/fuel ratio - " + message[2]);
	}

}
