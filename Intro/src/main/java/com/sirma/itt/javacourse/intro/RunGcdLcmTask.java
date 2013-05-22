package com.sirma.itt.javacourse.intro;

/**
 * run class for GcdLcmTask.
 * 
 * @author Fester
 */
public final class RunGcdLcmTask {
	private static GcdLcmTask calc = new GcdLcmTask();

	/**
	 * constructor.
	 */
	private RunGcdLcmTask() {
	}

	/**
	 * run class for GcdLcmTask.
	 * 
	 * @param args
	 *            no
	 */
	public static void main(String[] args) {

		int num1 = 12;
		int num2 = 32;

		System.out.println(calc.gcd(num1, num2));
		System.out.println(calc.lcm(num1, num2));
	}

}
