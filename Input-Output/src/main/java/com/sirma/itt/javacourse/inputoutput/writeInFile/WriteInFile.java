package com.sirma.itt.javacourse.inputoutput.writeInFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
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
	public void write() throws IOException {

		String file = sc.nextLine();
		FileWriter fw = null;

		fw = new FileWriter(file, true);

		String line = sc.nextLine();
		while (!".".equals(line)) {
			try {
				fw.append(line);
			} catch (IOException e) {
				e.printStackTrace();
				sc.close();
			}
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
	public static Scanner getSc() {
		return sc;
	}

	/**
	 * Sets the sc.
	 * 
	 * @param stream
	 *            the new sc
	 */
	public void setSc(InputStream stream) {
		WriteInFile.sc = new Scanner(stream);
	}
}
