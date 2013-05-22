package com.sirma.itt.javacourse.intro;

import java.util.Arrays;

/**
 * masivi.
 * 
 * @author Fester
 */
public class ArraysTask {

	/**
	 * calculating minimum element of array.
	 * 
	 * @param arr
	 *            integer array
	 * @return minElement
	 */
	public int getMinElement(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		Arrays.sort(arr);
		return arr[0];
	}

	/**
	 * calculating sum of all elements in array.
	 * 
	 * @param arr
	 *            integer array
	 * @return sum of elements
	 */
	public int getSum(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		int sum = 0;
		int arrLength = arr.length;
		for (int i = 0; i < arrLength; i++) {
			sum += arr[i];
		}

		return sum;
	}

	/**
	 * converts array to string for printing.
	 * 
	 * @param arr
	 *            int array
	 * @return string of all elements
	 */
	protected String arrToStr(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}

		String elements = "";
		int arrLength = arr.length;
		for (int i = 0; i < arrLength; i++) {
			elements += arr[i];
			if (i < arrLength - 1) {
				elements += ", ";
			}
		}

		return elements;
	}

	/**
	 * print all elements of an array.
	 * 
	 * @param arr
	 *            integer array
	 */
	public void printArray(int[] arr) {
		String str = arrToStr(arr);
		System.out.println(str);
	}
}
