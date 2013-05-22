package com.sirma.itt.javacourse.intro;

import org.apache.log4j.Logger;

/**
 * @author Fester
 */
public final class RunArraysTask {
	private static ArraysTask arr = new ArraysTask();

	/**
	 * constructor.
	 */
	private RunArraysTask() {

	}

	/**
	 * run class for ArrayTask.
	 * 
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {
		Logger log = Logger.getLogger("com.sirma.itt");
		final int[] test = { 100, 12, 12, 1, 2, 3 };

		log.debug(arr.getMinElement(test));
		log.debug(arr.getSum(test));
		arr.printArray(test);
	}

}
