package com.sirma.itt.javacourse.intro;

/**
 * Run class for string calculator.
 * 
 * @author Fester
 */
public final class RunStringCalculator {
	private static StringCalculator strCalc = new StringCalculator();

	/**
	 * constructor.
	 */
	private RunStringCalculator() {

	}

	/**
	 * main.
	 * 
	 * @param args
	 *            no args
	 */
	public static void main(String[] args) {
		String str1 = "9999";
		String str2 = "7787";

		System.out.println(strCalc.calc(str1, str2));
	}

}
