package com.sirma.itt.javacourse.inputoutput;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * Class Run ReverseFile.
 */
public final class RunReverseFile {

	/**
	 * Instantiates a new run reverse file.
	 */
	private RunReverseFile() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             io exception
	 */
	public static void main(String[] args) throws IOException {
		ReverseFile reverse = new ReverseFile();
		reverse.reverse();
	}

}
