package com.sirma.itt.javacourse.libs;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.intro.ArraysTask;
import com.sirma.itt.javacourse.intro.GcdLcmTask;
import com.sirma.itt.javacourse.intro.QuickSort;
import com.sirma.itt.javacourse.intro.RandomString;
import com.sirma.itt.javacourse.intro.ReverseArray;

/**
 * reusing jar code.
 * 
 * @author Fester
 */
public final class ReuseJarCode {
	private static Logger log = Logger.getLogger("com.sirma.itt");

	/**
	 * constructor.
	 */
	private ReuseJarCode() {

	}

	/**
	 * reusing reverse array.
	 */
	private static void reverse() {
		ReverseArray rev = new ReverseArray();
		int[] arr = { 1, 4, 7, 9, 6, 4, 3, 4, 6, 84, 55, 34, 76 };
		log.debug(rev.reverseArray(arr));
	}

	/**
	 * reusting random string generator.
	 */
	private static void randString() {
		RandomString rand = new RandomString();
		log.debug(rand.randomString(10));
	}

	/**
	 * reusing quicksort.
	 */
	private static void quickSort() {
		QuickSort qs = new QuickSort();
		int[] testArr = { 5, 7, 3, 4, 7, 8 };
		log.debug(qs.qSort(testArr, 0, testArr.length - 1));
	}

	/**
	 * reusing gcdLcm.
	 */
	private static void gcdLcm() {
		GcdLcmTask gcd = new GcdLcmTask();
		log.debug(gcd.lcm(20, 10));
		log.debug(gcd.gcd(20, 10));
	}

	/**
	 * reusting array operations class.
	 */
	private static void arr() {
		ArraysTask array = new ArraysTask();
		int[] testArr = { 5, 7, 3, 4, 7, 8 };
		log.debug(array.getMinElement(testArr));
		log.debug(array.getSum(testArr));
		array.printArray(testArr);
	}

	/**
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {
		gcdLcm();
		arr();
		quickSort();
		reverse();
		randString();
	}

}
