package com.sirma.itt.javacourse.intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Fester
 */
public class StringCalculator {

	/**
	 * calculating aggregation of 2 numbers with random length.
	 * 
	 * @param num1
	 *            random length number
	 * @param num2
	 *            random length number
	 * @return aggregation of the 2 numbers as string
	 */
	public String calc(String num1, String num2) {
		// wrong data tests
		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Can't calculate empty strings");
		}

		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher m1 = pattern.matcher(num1);
		Matcher m2 = pattern.matcher(num2);

		if (m1.find() || m2.find()) {
			throw new IllegalArgumentException("Enter only numbers without letters and other signs");
		}

		char[] number1 = num1.toCharArray();
		char[] number2 = num2.toCharArray();
		int num1Length = number1.length - 1;
		int num2Length = number2.length - 1;

		// calculating
		if (num1Length > num2Length) {
			return notEqual(num1, num2);
		} else if (num1Length < num2Length) {
			return notEqual(num2, num1);
		} else {
			return equal(num1, num2);
		}
	}

	/**
	 * if the numbers are with equal length.
	 * 
	 * @param num1
	 *            num1
	 * @param num2
	 *            num2
	 * @return result
	 */
	protected String equal(String num1, String num2) {
		char[] number1 = num1.toCharArray();
		char[] number2 = num2.toCharArray();
		int temp;
		int num1Length = number1.length - 1;
		int num2Length = number2.length - 1;
		char[] res = new char[num2Length + 2];
		res[0] = '1';
		int z = 0;
		int zero = 0;
		int i;

		for (i = num1Length; i >= 0; i--) {
			temp = Character.getNumericValue(number1[i]) + Character.getNumericValue(number2[i]);
			if (temp >= 10) {
				number2[i] = Character.forDigit(temp % 10, 10);
				if (i >= 1) {
					number2[i - 1] = (char) (number2[i - 1] + 1);

					zero = i;
					if (number2[i - 1] == ':') {
						number2[i - 1] = '0';
						zero = i;
					}
					while (number2[zero - 1] == '0') {
						zero--;
						number2[zero - 1] = (char) (number2[zero - 1] + 1);
					}

				} else {
					while (z < num2Length + 1) {
						res[z + 1] = number2[z];
						z++;
					}
					return String.copyValueOf(res);
				}
			} else {
				number2[i] = Character.forDigit(temp % 10, 10);
				zero--;

			}
		}
		return String.copyValueOf(number2);
	}

	/**
	 * if 1 of the numbers is with bigger length.
	 * 
	 * @param greater
	 *            number with bigger length
	 * @param smaller
	 *            number with smaller length
	 * @return result
	 */
	protected String notEqual(String greater, String smaller) {
		char[] number1 = greater.toCharArray();
		char[] number2 = smaller.toCharArray();
		int temp;
		int num1Length = number1.length - 1;
		int num2Length = number2.length - 1;
		char[] res = new char[num2Length + 2];
		res[0] = '1';
		int zero = 0;
		int i;

		for (i = num2Length; i >= 0; i--) {
			temp = Character.getNumericValue(number2[i])
					+ Character.getNumericValue(number1[num1Length]);
			if (temp >= 10) {
				number1[num1Length] = Character.forDigit(temp % 10, 10);

				number1[num1Length - 1] = (char) (number1[num1Length - 1] + 1);

				zero = num1Length;
				if (number1[num1Length - 1] == ':') {
					number1[num1Length - 1] = '0';
				}
				while (number1[zero - 1] == '0') {
					zero--;
					number1[zero - 1] = (char) (number1[zero - 1] + 1);
					if (number1[zero - 1] == ':')
						number1[zero - 1] = '0';
				}

				num1Length--;
			} else {
				number1[num1Length] = Character.forDigit(temp % 10, 10);
				num1Length--;
			}
		}
		res = number1.clone();
		return String.copyValueOf(res);
	}
}
