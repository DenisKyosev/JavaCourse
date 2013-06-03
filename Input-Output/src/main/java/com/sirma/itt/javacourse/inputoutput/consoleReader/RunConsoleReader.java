package com.sirma.itt.javacourse.inputoutput.consoleReader;

/**
 * The Class RunConsoleReader.
 */
public final class RunConsoleReader {

	/**
	 * Instantiates a new run console reader.
	 */
	private RunConsoleReader() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ConsoleReader read = new ConsoleReader();
		System.out.println(read.readString());
		System.out.println(read.readInt());
		System.out.println(read.readFloat());
		System.out.println(read.readChar());
	}

}
