package com.sirma.itt.javacourse.netAndGui.task1;

public class CalculatorFunctions {
	private final String dotPattern = "\\.";
	private final String zerosPattern = ".*[1-9].*";

	protected boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	protected String deleteDigit(String input) {
		if (input.length() > 0 && !"0".equals(input)) {
			return input.substring(0, input.length() - 1);
		} else {
			return "";
		}
	}

	protected String putDot(String input) {
		if (!input.contains(".")) {
			return input + ".";
		} else {
			return input;
		}
	}

	protected String removeDot(String input) {
		if (input.contains(".")) {
			if (!input.split(dotPattern)[1].matches(zerosPattern)) {
				input = input.split(dotPattern)[0];
			}
		}
		return input;
	}

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
