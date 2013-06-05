package com.sirma.itt.javacourse.designpatterns.command;

/**
 * The Interface Command.
 */
public interface Command {

	/**
	 * Execute given command with given string to calculate.
	 * 
	 * @param str
	 *            the input
	 * @param cmd
	 *            the command to be executed
	 * @return the double result
	 */
	double execute(String str, Calculate cmd);
}
