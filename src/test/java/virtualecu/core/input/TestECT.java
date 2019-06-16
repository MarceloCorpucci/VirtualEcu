package virtualecu.core.input;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestECT {
	private ECT ect; 
	
	@Before
	public void setUp() {
		ect = new ECT(true);
	}
	
	@Test
	public void completeSensorNameIsAvailable() {
        assertThat(ect, hasProperty("name", is("Engine Coolant Temperature Sensor")));	
	}

	@Test
	public void containsCelsiusProperty() {
        assertThat(ect, hasProperty("celsius"));	
	}
}
