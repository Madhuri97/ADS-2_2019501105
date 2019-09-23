/**
 * This is JUnit that tests the simpleInterest method 
 * that is available in SimpleInterest class. This contains 10 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase6).
 * 
 * @author: Siva Sankar
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(0.06, SimpleInterest.simpleInterest(1, 2, 3), 0.001);
	}

	@Test
	public void testCase2() {
		assertEquals(24000.0, SimpleInterest.simpleInterest(100000, 2, 12), 0.001);
	}

	@Test
	public void testCase3() {
		assertEquals(480000.0, SimpleInterest.simpleInterest(1000000, 2, 24), 0.001);
	}

	@Test
	public void testCase4() {
		assertEquals(360000.0, SimpleInterest.simpleInterest(1000000, 2, 18), 0.001);
	}

	@Test
	public void testCase5() {
		assertEquals(30000.0, SimpleInterest.simpleInterest(100000, 2, 15), 0.001);
	}

	@Test
	public void testCase6() {
		assertEquals(19668.0, SimpleInterest.simpleInterest(65560, 2, 15), 0.001);
	}
}