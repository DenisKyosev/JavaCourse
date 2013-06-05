package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * The Class PlusCommand.
 */
public class PlusCommand implements Command {

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
		return calc.plus(str);
	}

}
