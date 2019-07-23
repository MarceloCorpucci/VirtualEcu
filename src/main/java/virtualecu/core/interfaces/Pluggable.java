package virtualecu.core.interfaces;

public interface Pluggable {
	void connectToMainBus();
	void connectToInputBus();
	void connectToOutputBus();
	void startEcu();
	void getRpms();
	void showAirPressure();
	void showEngineTemp();
	void measureAirDensity();
	void accelerate();
	void measureAirFuelRatio();
	
}
