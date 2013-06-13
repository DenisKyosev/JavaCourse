package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * The Class MinusCommand.
 */
public class MinusCommand implements Command {

	/**
	 * Execute minus.
	 * 
	 * @param input
	 *            the input
	 * @return double result
	 * @Override
	 */
	@Override
	public double execute(String input) {
		String[] in = input.split("\\-");
		double result = Double.parseDouble(in[0]);
		for (int i = 1; i < in.length; i++) {
			result -= Double.parseDouble(in[i]);
		}

		return result;
	}

}
