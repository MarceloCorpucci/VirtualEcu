package virtualecu.core.interfaces;

public interface Displayable {
	Displayable receive(String[] message);
	Displayable receive(String message);
	void showSimpleMessage();
	void showRpms();
	void showAirAirPressure();
	void showStandardMessage();
	void showAirFuelRatio();

}
