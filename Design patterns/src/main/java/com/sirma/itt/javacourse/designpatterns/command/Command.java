package com.sirma.itt.javacourse.designpatterns.command;

// TODO: Auto-generated Javadoc
/**
 * The Interface Command.
 */
public interface Command {

	/**
	 * Execute given command with given string to calculate.
	 * 
	 * @param str
	 *            the input
	 * @return the double result
	 */
	double execute(String str);
}
