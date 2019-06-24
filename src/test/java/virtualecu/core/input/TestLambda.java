package virtualecu.core.input;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestLambda {
	private Lambda lambda; 
	
	@Before
	public void setUp() {
		lambda = new Lambda();
	}
	
	@Test
	public void testMeasureRatioSetsRichMixtureWithoutHeating() {
		lambda.measureRatio(11.5f);
        assertThat(lambda.getState(), is("Heating sensor. Rich Mixture"));	
	}
	
	@Test
	public void testMeasureRatioSetsLeanMixtureWithoutHeating() {
		lambda.measureRatio(15.5f);
        assertThat(lambda.getState(), is("Heating sensor. Lean Mixture"));	
	}
	
	@Test
	public void testMeasureRatioSetsRichMixtureWithHeating() {
		lambda.measureRatio(11.5f);
		lambda.measureRatio(11.5f);
        assertThat(lambda.getState(), is("Rich Mixture"));	
	}
	
	@Test
	public void testMeasureRatioSetsLeanMixtureHeating() {
		lambda.measureRatio(15.5f);
		lambda.measureRatio(15.5f);
        assertThat(lambda.getState(), is("Lean Mixture"));	
	}

}
