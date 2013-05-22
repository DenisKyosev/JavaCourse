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
	 */
	protected void write() {

		String file = sc.nextLine();
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String line = sc.nextLine();
		while (!".".equals(line)) {
			try {
				fw.append(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
			line = sc.nextLine();
		}

		try {
			sc.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Write.
	 * 
	 * @param stream
	 *            the stream
	 */
	protected void write(InputStream stream) {
		sc = new Scanner(stream);
		this.write();
	}
}
