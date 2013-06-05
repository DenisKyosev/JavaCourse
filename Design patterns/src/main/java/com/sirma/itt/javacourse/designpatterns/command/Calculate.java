package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * Calculation of the given string.
 */
public class Calculate {

	/**
	 * Division.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double division(String input) {
		String[] in = input.split("\\/");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result /= Double.parseDouble(in[i]);
		}
		return result;
	}

	/**
	 * Multiply.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double multiply(String input) {
		String[] in = input.split("\\*");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result *= Double.parseDouble(in[i]);
		}
		return result;
	}

	/**
	 * Gradation.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double gradation(String input) {
		String[] in = input.split("\\^");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result = Math.pow(result, Double.parseDouble(in[i]));
		}
		return result;
	}

	/**
	 * aggregation.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double plus(String input) {
		String[] in = input.split("\\+");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result += Double.parseDouble(in[i]);
		}
		return result;
	}

	/**
	 * Substaction.
	 * 
	 * @param input
	 *            the input
	 * @return the double result
	 */
	public double minus(String input) {
		String[] in = input.split("\\-");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result -= Double.parseDouble(in[i]);
		}

		return result;
	}
}
