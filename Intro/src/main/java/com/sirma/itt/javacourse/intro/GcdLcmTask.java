package com.sirma.itt.javacourse.intro;

/**
 * class for calculating GCD and LCM.
 * 
 * @author Fester
 */
public class GcdLcmTask {

	/**
	 * calculating GCD of 2 numbers.
	 * 
	 * @param num1
	 *            integer
	 * @param num2
	 *            integer
	 * @return GCD of num1 and num2
	 */
	public int gcd(int num1, int num2) {

		int num1Temp = num1;
		int num2Temp = num2;
		while (num1Temp != num2Temp) {
			if (num1Temp > num2Temp) {
				num1Temp = num1Temp - num2Temp;
			} else {
				num2Temp = num2Temp - num1Temp;
			}
		}
		return num1Temp;
	}

	/**
	 * calculating LCM of 2 numbers.
	 * 
	 * @param num1
	 *            integer
	 * @param num2
	 *            integer
	 * @return LCM of num1 and num2
	 */
	public int lcm(int num1, int num2) {

		return num1 * num2 / (gcd(num1, num2));
	}

}
