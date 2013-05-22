package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sirma.itt.javacourse.intro.StringCalculator;

/**
 * sum of 2 random type variables.
 * 
 * @author Fester
 */
public class Sumator {

	/**
	 * sum of 2 ints.
	 * 
	 * @param num1
	 *            number
	 * @param num2
	 *            number
	 * @return sum
	 */
	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	/**
	 * sum of 2 floats.
	 * 
	 * @param num1
	 *            number
	 * @param num2
	 *            number
	 * @return sum
	 */
	public float sum(float num1, float num2) {
		return num1 + num2;
	}

	/**
	 * sum of 2 Strings.
	 * 
	 * @param num1
	 *            number
	 * @param num2
	 *            number
	 * @return sum
	 */
	public String sum(String num1, String num2) {

		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Can't calculate empty strings");
		}

		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher m1 = pattern.matcher(num1);
		Matcher m2 = pattern.matcher(num2);

		if (m1.find() || m2.find()) {
			throw new IllegalArgumentException("Enter only numbers without letters and other signs");
		}

		StringCalculator calc = new StringCalculator();
		String sum = calc.calc(num1, num2);

		return sum;
	}

	/**
	 * sum of 2 Big Integers.
	 * 
	 * @param num1
	 *            number
	 * @param num2
	 *            number
	 * @return sum
	 */
	public BigInteger sum(BigInteger num1, BigInteger num2) {
		BigInteger res = num1.add(num2);
		return res;
	}

	/**
	 * sum of 2 Big Decimals.
	 * 
	 * @param num1
	 *            number
	 * @param num2
	 *            number
	 * @return sum
	 */
	public BigDecimal sum(BigDecimal num1, BigDecimal num2) {
		BigDecimal res = num1.add(num2);
		return res;
	}
}
