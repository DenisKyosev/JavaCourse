package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing class for Center Weight task.
 * 
 * @author Fester
 */
public class TestCenterWeight {
	private CenterWeight arr = new CenterWeight();

	/**
	 * testing center weight method.
	 */
	@Test
	public void testWeight() {
		int[] test1 = { 1, 2, 3, 4, 5 };
		int[] test2 = { 12, 3, 2, 4, 3, 1, 1, 1, 1, 8 };
		int[] test3 = { 1, 1, 1, 1, 100, 1, 1, 1, 100 };
		assertEquals("center must be 4", 4, arr.arrWeight(test1));
		assertEquals("center must be 4", 4, arr.arrWeight(test2));
		assertEquals("center must be 5", 5, arr.arrWeight(test3));
	}

	/**
	 * testing null data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWeightNull() {

		assertEquals("null array", arr.arrWeight(null));
	}

}