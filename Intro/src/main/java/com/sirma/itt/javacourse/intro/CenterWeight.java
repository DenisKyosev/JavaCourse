package com.sirma.itt.javacourse.intro;

/**
 * @author Fester
 */
public class CenterWeight {
	/**
	 * @param arr
	 *            - array with integers
	 * @return center weight of the array
	 */
	public int arrWeight(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}

		int sum = 0;
		int sum2 = 0;
		int i;

		for (i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		sum = sum / 2;
		i = 0;
		while (sum >= sum2) {
			sum2 += arr[i];
			i++;
		}

		return i;
	}
}
