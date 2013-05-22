package com.sirma.itt.javacourse.intro;

/**
 * reversing array.
 * 
 * @author Fester
 */
public class ReverseArray {

	/**
	 * @param arr
	 *            array to be reversed
	 * @return reversed array
	 */
	public int[] reverseArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}

		int[] arr2 = arr.clone();
		int left = 0;
		int right = arr2.length - 1;
		int temp;

		while (left != right) {
			temp = arr2[left];
			arr2[left] = arr2[right];
			arr2[right] = temp;
			left++;
			right--;
		}
		return arr2;
	}
}
