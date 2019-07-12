package virtualecu.core.processor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.input.CKP;

public class TestCalculationCoprocessor {
	private CKP ckp;
	private CalculationCoprocessor calculationCoprocessor;
	
	@Before
	public void setUp() {
		ckp = new CKP();
		calculationCoprocessor = new CalculationCoprocessor();
	}
	
	@Test
	public void testShowRPM() {
		ckp.setUnitValue();
		calculationCoprocessor.setCkp(ckp);
		int rpms = calculationCoprocessor.showRpm();
		assertThat(rpms, is(equalTo(756)));
	}
	
}
