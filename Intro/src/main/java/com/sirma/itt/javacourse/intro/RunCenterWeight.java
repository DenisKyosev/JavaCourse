package com.sirma.itt.javacourse.intro;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * run class for CenterWeight.
 */
public final class RunCenterWeight {
	private static CenterWeight arr = new CenterWeight();

	/**
	 * constructor.
	 */
	private RunCenterWeight() {

	}

	/**
	 * main method launching CentherWeight.
	 * 
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("com.sirma.itt");
		int[] test = { 1, 1, 1, 1, 100, 1, 1, 1, 100 };
		logger.log(Level.DEBUG, arr.arrWeight(test));
	}
}
