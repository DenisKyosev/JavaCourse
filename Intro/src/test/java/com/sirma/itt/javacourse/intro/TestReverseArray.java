package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * testing reverse function.
 * 
 * @author Fester
 */
public class TestReverseArray {
	private ReverseArray arr = new ReverseArray();

	/**
	 * testing reverse array function.
	 */
	@Test
	public void testReverse() {

		int[] test1 = { 1, 4, 7, 9, 6, 4, 3, 4, 6, 84, 55, 34, 76 };
		int[] test1Reversed = { 76, 34, 55, 84, 6, 4, 3, 4, 6, 9, 7, 4, 1 };
		test1 = arr.reverseArray(test1);
		Assert.assertArrayEquals("ok", test1Reversed, test1);
	}

	/**
	 * testing null data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWeightNull() {

		assertEquals("null array", arr.reverseArray(null));
	}
}
