package virtualecu.core.input;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestCKP {
	private CKP ckp; 
	
	@Before
	public void setUp() {
		ckp = new CKP();
	}
	
	@Test
	public void completeSensorNameIsAvailable() {
        assertThat(ckp, hasProperty("name", is("Crankshaft Position Sensor")));	
	}

	@Test
	public void containsAngleProperty() {
        assertThat(ckp, hasProperty("unitValue"));	
	}
}
