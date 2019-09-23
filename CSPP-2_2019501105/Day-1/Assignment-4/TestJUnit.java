/**
 * This is JUnit that tests the abs and AbsoluteNumber methods
 *  that is available in AreaOfCircle class. This contains 10 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase10).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(12, AbsoluteNumber.abs(12));
	}

	@Test
	public void testCase2() {
		assertEquals(12, AbsoluteNumber.abs(-12));
	}

	@Test
	public void testCase3() {
		assertEquals(1, AbsoluteNumber.abs(-1));
	}

	@Test
	public void testCase4() {
		assertEquals(10, AbsoluteNumber.abs(-10));
	}

	@Test
	public void testCase5() {
		assertEquals(2147483646, AbsoluteNumber.abs(-2147483646));
	}

	@Test
	public void testCase6() {
		assertEquals(2147483647, AbsoluteNumber.abs(-2147483647));
	}

	@Test
	public void testCase7() {
		assertEquals(2147483647, AbsoluteNumber.abs(2147483647));
	}

	@Test
	public void testCase8() {
		assertEquals(0, AbsoluteNumber.abs(0));
	}

	@Test
	public void testCase9() {
		assertEquals(2, AbsoluteNumber.abs(-2));
	}

	@Test
	public void testCase10() {
		assertEquals(3, AbsoluteNumber.abs(-3));
	}
}