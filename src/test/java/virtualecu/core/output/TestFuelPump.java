package virtualecu.core.output;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestFuelPump {
	private FuelPump fuelPump;
	
	@Before
	public void setUp() {
		fuelPump = new FuelPump();
	}
	
	@Test
	public void testGetFuelPumpStateDeactivated() {
		assertThat(fuelPump.getFuelPumpState(), is(equalTo("Fuel Pump deactivated.")));
	}

	@Test
	public void testGetFuelPumpStateActivated() {
		fuelPump.activate();
		assertThat(fuelPump.getFuelPumpState(), is(equalTo("Fuel Pump activated.")));
	}
	
}
