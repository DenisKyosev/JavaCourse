package com.sirma.itt.javacourse.inputoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * WriteInFile.
 */
public class WriteInFile {

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

		fw = new FileWriter(file);

		String line = sc.nextLine();
		while (!".".equals(line)) {
			try {
				fw.append(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
			line = sc.nextLine();
		}

		sc.close();
		fw.close();

	}

	/**
	 * Write.
	 * 
	 * @param stream
	 *            the stream
	 * @throws IOException
	 *             io exception
	 */
	protected void write(InputStream stream) throws IOException {
		sc = new Scanner(stream);
		this.write();
	}
}
