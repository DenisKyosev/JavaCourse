package com.sirma.itt.javacourse.netAndGui.task1;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculatorFunctions.
 */
public class CalculatorFunctions {

	/** finding a dot pattern. */
	private final String dotPattern = "\\.";

	/** finding only non zeros pattern. */
	private final String zerosPattern = ".*[1-9].*";

	/**
	 * Checks if the source is number.
	 * 
	 * @param s
	 *            the source
	 * @return true, if it is a number
	 */
	protected boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Delete 1 digit.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	protected String deleteDigit(String input) {
		if (input.length() > 0 && !"0".equals(input)) {
			return input.substring(0, input.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * Put dot.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	protected String putDot(String input) {
		if (!input.contains(".")) {
			return input + ".";
		} else {
			return input;
		}
	}

	/**
	 * Removes the dot and zeros in the end if there are only zeros.
	 * 
	 * @param input
	 *            the input
	 * @return the string
	 */
	protected String removeDot(String input) {
		if (input.contains(".")) {
			if (!input.split(dotPattern)[1].matches(zerosPattern)) {
				input = input.split(dotPattern)[0];
			}
		}
		return input;
	}

	/**
	 * Performing calculations.
	 * 
	 * @param operation
	 *            the operation
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the string
	 */
	protected String equal(int operation, Double x, Double y) {
		String result = "";

		if (operation == 1) {
			result = Double.toString(x + y);
		} else if (operation == 2) {
			result = Double.toString(x - y);
		} else if (operation == 3) {
			result = Double.toString(x * y);
		} else if (operation == 4) {
			result = Double.toString(x / y);
		}

		result = removeDot(result);
		return result;
	}

}
