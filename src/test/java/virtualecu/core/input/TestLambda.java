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
	public void testMeasureRatioSetsRichMixture() {
		lambda.measureRatio(11.5f);
        assertThat(lambda.getState(), is("Rich Mixture"));	
	}
	
	@Test
	public void testMeasureRatioSetsLeanMixture() {
		lambda.measureRatio(15.5f);
        assertThat(lambda.getState(), is("Lean Mixture"));	
	}

}
