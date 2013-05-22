package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * testing array functions.
 * 
 * @author Fester
 */
public class TestQuickSort {
	private QuickSort arr = new QuickSort();

	/**
	 * testing quicksort function.
	 */
	@Test
	public void testQuickSort() {
		int[] test1 = { 1, 4, 7, 9, 6, 4, 3, 4, 6, 84, 55, 34, 76 };
		int[] test1res1 = test1.clone();

		Arrays.sort(test1res1);
		int[] test1res2 = arr.qSort(test1);

		Assert.assertArrayEquals("ok", test1res1, test1res2);

		int[] test2 = { 3, 6, 8, 4, 43, 6, 76 };
		int[] test2res1 = test2.clone();

		Arrays.sort(test2res1);
		int[] test2res2 = arr.qSort(test2);

		Assert.assertArrayEquals("ok", test2res1, test2res2);

	}

	/**
	 * testing null data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNull() {

		assertEquals("null array", arr.qSort(null));
	}
}
