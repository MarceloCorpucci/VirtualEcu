package virtualecu.core.input;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestTPS {
	private TPS tps; 
	
	@Before
	public void setUp() {
		tps = new TPS();
	}
	
	@Test
	public void completeSensorNameIsAvailable() {
        assertThat(tps, hasProperty("name", is("Throttle Position Sensor")));	
	}

	@Test
	public void containsAngleProperty() {
        assertThat(tps, hasProperty("angle"));	
	}
}
