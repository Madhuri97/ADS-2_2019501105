/**
 * This is JUnit that tests the areaOfCircle and perimeterOfCircle methods
 *  that is available in AreaOfCircle class. This contains 14 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase14).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(3.14159, AreaOfCircle.areaOfCircle(1), 0.001);
	}

	@Test
	public void testCase2() {
		assertEquals(28.274309999999996, AreaOfCircle.areaOfCircle(3), 0.001);
	}

	@Test
	public void testCase3() {
		assertEquals(12.56636, AreaOfCircle.areaOfCircle(2), 0.001);
	}

	@Test
	public void testCase4() {
		assertEquals(30.974820764, AreaOfCircle.areaOfCircle(3.14), 0.001);
	}

	@Test
	public void testCase5() {
		assertEquals(15.483012156000003, AreaOfCircle.areaOfCircle(2.22), 0.001);
	}

	@Test
	public void testCase6() {
		assertEquals(1551.0922041559998, AreaOfCircle.areaOfCircle(22.22), 0.001);
	}

	@Test
	public void testCase7() {
		assertEquals(169403.5723136767, AreaOfCircle.areaOfCircle(232.213), 0.001);
	}

	@Test
	public void testCase8() {
		assertEquals(6.28318, AreaOfCircle.perimeterOfCircle(1), 0.001);
	}

	@Test
	public void testCase9() {
		assertEquals(18.849539999999998, AreaOfCircle.perimeterOfCircle(3), 0.001);
	}

	@Test
	public void testCase10() {
		assertEquals(12.56636, AreaOfCircle.perimeterOfCircle(2), 0.001);
	}

	@Test
	public void testCase11() {
		assertEquals(19.7291852, AreaOfCircle.perimeterOfCircle(3.14), 0.001);
	}

	@Test
	public void testCase12() {
		assertEquals(13.948659600000001, AreaOfCircle.perimeterOfCircle(2.22), 0.001);
	}

	@Test
	public void testCase13() {
		assertEquals(139.6122596, AreaOfCircle.perimeterOfCircle(22.22), 0.001);
	}

	@Test
	public void testCase14() {
		assertEquals(1459.03607734, AreaOfCircle.perimeterOfCircle(232.213), 0.001);
	}
}