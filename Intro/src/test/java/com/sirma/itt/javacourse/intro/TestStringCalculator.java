package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * testing string calculator function.
 * 
 * @author Fester
 */
public class TestStringCalculator {
	private StringCalculator calc = new StringCalculator();

	/**
	 * testing string calculator function.
	 */
	@Test
	public void testCalc() {
		String str1 = "88876599945568";
		String str2 = "7768778899";

		assertEquals("ok", "88884368724467", calc.calc(str1, str2));

		str1 = "987654567";
		str2 = "345676543";

		assertEquals("ok", "1333331110", calc.calc(str1, str2));

		str1 = "34567543";
		str2 = "88876599945568";

		assertEquals("ok", "88876634513111", calc.calc(str1, str2));
	}

	/**
	 * testing null strings.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		String str1 = null;
		String str2 = null;

		assertEquals("ok", calc.calc(str1, str2));
	}

	/**
	 * testing null strings.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWrongData() {
		String str1 = "asfa";
		String str2 = "asda";

		assertEquals("ok", calc.calc(str1, str2));
	}
}
