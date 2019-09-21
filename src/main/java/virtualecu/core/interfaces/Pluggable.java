package virtualecu.core.interfaces;

public interface Pluggable {
	void connectToMainBus();
	void connectToInputBus();
	void connectToOutputBus();
	void startEcu();
	void informRpms();
	String[] informRpms(float tpsAngle);
	void informAirPressure(float mapAirPressure, float bsAirPressure);
	void informEngineTemp(float temp);
	void measureAirDensity(float airTemp, float mapAirPressure, float bsAirPressure);
//	void accelerate();
	void measureAirFuelRatio(float airFuelRatio);
	
}
