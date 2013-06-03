package com.sirma.itt.javacourse.inputoutput.consoleReader;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

/**
 * read from console.
 */
public final class ConsoleReader {

	/** The sc. */
	private Scanner sc = new Scanner(System.in);

	/**
	 * Gets the sc.
	 * 
	 * @return the sc
	 */
	protected Scanner getSc() {
		return sc;
	}

	/**
	 * Sets the sc.
	 * 
	 * @param stream
	 *            the new sc
	 */
	protected void setSc(InputStream stream) {
		this.sc = new Scanner(stream);
	}

	/**
	 * Read string.
	 * 
	 * @return the string
	 */
	protected String readString() {
		String str = sc.nextLine();
		return str;
	}

	/**
	 * Read int.
	 * 
	 * @return the int
	 */
	protected int readInt() {
		if (!sc.hasNextInt()) {
			throw new IllegalArgumentException();
		}
		int num = sc.nextInt();
		return num;
	}

	/**
	 * Read char.
	 * 
	 * @return the char
	 */
	protected char readChar() {
		char ch = sc.findInLine(".").charAt(0);

		return ch;
	}

	/**
	 * Read float.
	 * 
	 * @return the float
	 */
	protected float readFloat() {
		sc.useLocale(Locale.US);
		if (!sc.hasNextFloat()) {
			throw new IllegalArgumentException();
		}
		float num = sc.nextFloat();
		return num;
	}

}
