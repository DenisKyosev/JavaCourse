package com.sirma.itt.javacourse.designpatterns.command;

/**
 * The Class GradationCommand.
 */
public class GradationCommand implements Command {

	/** The calculator. */
	private final Calculate calc = new Calculate();

	/**
	 * @Override
	 * @return double result
	 * @param str
	 *            input string
	 * @param cmd
	 *            command
	 */
	public double execute(String str, Calculate cmd) {
		return calc.gradation(str);
	}
}
