package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * testing array functions.
 * 
 * @author Fester
 */
public class TestArraysTask {
	private ArraysTask arr = new ArraysTask();

	/**
	 * testing minimum element function.
	 */
	@Test
	public void testgetMinElement() {
		final int[] test1 = { 2, 6, 9, 4, 2, 1 };
		final int[] test2 = { 100, 43, 65, 324, 767, 41 };
		assertEquals("Must return 1", 1, arr.getMinElement(test1));
		assertEquals("Must return 41", 41, arr.getMinElement(test2));
	}

	/**
	 * testing sum of element function.
	 */
	@Test
	public void testgetsum() {
		final int[] test1 = { 2, 6, 9, 4, 2, 1 };
		final int[] test2 = { 100, 12, 12, 1, 2, 3 };
		assertEquals("Must return 24", 24, arr.getSum(test1));
		assertEquals("Must return 130", 130, arr.getSum(test2));
	}

	/**
	 * testing print of array function.
	 */
	@Test
	public void testPrintArray() {
		final int[] test1 = { 2, 6, 9, 4, 2, 1 };
		final int[] test2 = { 100, 12, 12, 1, 2, 3 };
		assertEquals("Must return 24", "2, 6, 9, 4, 2, 1", arr.arrToStr(test1));
		assertEquals("Must return 130", "100, 12, 12, 1, 2, 3", arr.arrToStr(test2));
	}

	/**
	 * testing null pointer exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNulls() {
		assertEquals("null array", arr.arrToStr(null));
		assertEquals("null array", arr.getSum(null));
		assertEquals("null array", arr.getMinElement(null));
	}

}
