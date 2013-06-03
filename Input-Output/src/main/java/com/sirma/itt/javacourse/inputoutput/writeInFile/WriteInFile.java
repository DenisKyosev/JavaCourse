package com.sirma.itt.javacourse.inputoutput.writeInFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * WriteInFile.
 */
public class WriteInFile {

	/** The scanner. */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Write in file.
	 * 
	 * @throws IOException
	 *             io exception
	 */
	protected void write() throws IOException {

		String file = sc.nextLine();
		FileWriter fw = null;

		fw = new FileWriter(file, true);

		String line = sc.nextLine();
		while (!".".equals(line)) {
			fw.append(line);
			line = sc.nextLine();
		}

		sc.close();
		fw.close();

	}

	/**
	 * Gets the sc.
	 * 
	 * @return the sc
	 */
	protected static Scanner getSc() {
		return sc;
	}

	/**
	 * Sets the sc.
	 * 
	 * @param stream
	 *            the new sc
	 */
	protected void setSc(InputStream stream) {
		WriteInFile.sc = new Scanner(stream);
	}
}
