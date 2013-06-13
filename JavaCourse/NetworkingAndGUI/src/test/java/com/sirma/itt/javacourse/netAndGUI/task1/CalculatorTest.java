package com.sirma.itt.javacourse.netAndGUI.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testFunctions() {
		CalculatorFunctions func = new CalculatorFunctions();

		String input = "6.000";
		assertEquals("6", func.removeDot(input));

		input = "6.0008";
		assertEquals("6.0008", func.removeDot(input));

		input = "6.00890000000";
		assertEquals("6.00890000000", func.removeDot(input));
		assertEquals(true, func.isNumber(input));

		input = "6.0008";
		assertEquals("6.000", func.deleteDigit(input));

		input = "6.00";
		assertEquals("6.0", func.deleteDigit(input));
		assertEquals(true, func.isNumber(input));

		input = "6.00a";
		assertEquals(false, func.isNumber(input));

		input = "6.00";
		assertEquals("6.00", func.putDot(input));

		input = "6";
		assertEquals("6.", func.putDot(input));

		input = "6.";
		assertEquals("6.", func.putDot(input));

	}
}
