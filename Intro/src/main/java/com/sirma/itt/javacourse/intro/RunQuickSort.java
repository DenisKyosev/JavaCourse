package com.sirma.itt.javacourse.intro;

/**
 * run class for quicksort.
 * 
 * @author Fester
 */
public final class RunQuickSort {
	private static QuickSort qs = new QuickSort();

	/**
	 * constructor.
	 */
	private RunQuickSort() {

	}

	/**
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 4, 7, 9, 6, 4, 3, 4, 6, 84, 55, 34, 76 };
		int[] newArr = qs.qSort(arr, 0, arr.length - 1);

		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}

}
