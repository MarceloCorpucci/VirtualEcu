package virtualecu.core.input;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestMAP {
	private MAP map; 
	
	@Before
	public void setUp() {
		map = new MAP();
	}
	
	@Test
	public void completeSensorNameIsAvailable() {
        assertThat(map, hasProperty("name", is("Manifold Absolute Pressure Sensor")));	
	}

	@Test
	public void containsCelsiusProperty() {
        assertThat(map, hasProperty("unitValue"));	
	}
}
