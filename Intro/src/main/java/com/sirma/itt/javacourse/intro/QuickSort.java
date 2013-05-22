package com.sirma.itt.javacourse.intro;

/**
 * Quicksort method.
 * 
 * @author Fester
 */
public class QuickSort {

	/**
	 * Quicksort method.
	 * 
	 * @param arr
	 *            array to be sorted
	 * @param start
	 *            start pointer of the array
	 * @param end
	 *            end pointer
	 * @return sorted array
	 */
	public int[] qSort(int[] arr, int start, int end) {
		int[] arr2 = arr;
		int leftPoint = start;
		int rightPoint = end;
		int pivotPoint = leftPoint + (rightPoint - leftPoint) / 2;
		int pivotVal = arr2[pivotPoint];
		int tempPoint;

		do {

			while (arr2[leftPoint] < pivotVal) {
				leftPoint++;
			}
			while (arr2[rightPoint] > pivotVal) {
				rightPoint--;
			}
			if (leftPoint <= rightPoint) {
				tempPoint = arr2[leftPoint];
				arr2[leftPoint] = arr2[rightPoint];
				arr2[rightPoint] = tempPoint;
				leftPoint++;
				rightPoint--;
			}
		} while (leftPoint <= rightPoint);

		if (start < rightPoint) {
			qSort(arr2, start, rightPoint);
		}
		if (leftPoint < end) {
			qSort(arr2, leftPoint, end);
		}

		return arr2;
	}

	/**
	 * @param arr
	 *            array to be sorted
	 * @return sorted array
	 */
	int[] qSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException();
		}
		return qSort(arr, 0, arr.length - 1);
	}
}
