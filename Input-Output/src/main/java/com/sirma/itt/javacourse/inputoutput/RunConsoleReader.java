package com.sirma.itt.javacourse.inputoutput;

// TODO: Auto-generated Javadoc
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
		System.out.println(ConsoleReader.readString());
		System.out.println(ConsoleReader.readInt());
		System.out.println(ConsoleReader.readFloat());
		System.out.println(ConsoleReader.readChar());
	}

}
