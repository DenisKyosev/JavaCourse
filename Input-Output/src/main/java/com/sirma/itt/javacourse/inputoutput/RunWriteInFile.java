package com.sirma.itt.javacourse.inputoutput;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * Run WriteInFile.
 */
public final class RunWriteInFile {

	/**
	 * Instantiates a new run write in file.
	 */
	private RunWriteInFile() {

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
		WriteInFile fileWriter = new WriteInFile();

		fileWriter.write();
	}

}
