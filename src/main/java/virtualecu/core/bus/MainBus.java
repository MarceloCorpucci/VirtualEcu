package virtualecu.core.bus;

import virtualecu.core.interfaces.DisplayPort;
import virtualecu.core.processor.CalculationCoprocessor;
import virtualecu.core.processor.InjectionCoprocessor;
import virtualecu.core.processor.MeasurementCoprocessor;

public class MainBus {
	InjectionCoprocessor injectionCoprocessor;
	CalculationCoprocessor calculationCoprocessor;
	MeasurementCoprocessor measurementCoprocessor;
	DisplayPort displayPort;
	
	public MainBus () {
		this.injectionCoprocessor = new InjectionCoprocessor();
		this.calculationCoprocessor = new CalculationCoprocessor();
		this.measurementCoprocessor = new MeasurementCoprocessor();
		this.displayPort = new DisplayPort();
	}

	public InjectionCoprocessor toInjectionCoprocessor() {
		return injectionCoprocessor;
	}

	public CalculationCoprocessor toCalculationCoprocessor() {
		return calculationCoprocessor;
	}

	public MeasurementCoprocessor toMeasurementCoprocessor() {
		return measurementCoprocessor;
	}
	
	public DisplayPort toDisplayPort() {
		return displayPort;
	}
}
