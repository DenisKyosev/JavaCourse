package com.sirma.itt.javacourse.inputoutput;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * read from console.
 */
public final class ConsoleReader {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Instantiates a new console reader.
	 */
	private ConsoleReader() {

	}

	/**
	 * Read string.
	 * 
	 * @return the string
	 */
	public static String readString() {
		String str = sc.nextLine();
		return str;
	}

	/**
	 * Read string overload.
	 * 
	 * @param stream
	 *            fake console input
	 * @return the string
	 */
	public static String readString(InputStream stream) {
		sc = new Scanner(stream);
		String str = sc.nextLine();
		return str;
	}

	/**
	 * Read int.
	 * 
	 * @return the int
	 */
	public static int readInt() {
		if (!sc.hasNextInt()) {
			throw new IllegalArgumentException();
		}
		int num = sc.nextInt();
		return num;
	}

	/**
	 * Read int overload.
	 * 
	 * @param stream
	 *            fake console input
	 * @return the int
	 */
	public static int readInt(InputStream stream) {
		sc = new Scanner(stream);
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
	public static char readChar() {
		char ch = sc.findInLine(".").charAt(0);

		return ch;
	}

	/**
	 * Read char overload.
	 * 
	 * @param stream
	 *            fake console input
	 * @return the char
	 */
	public static char readChar(InputStream stream) {
		sc = new Scanner(stream);
		char ch = sc.findInLine(".").charAt(0);

		return ch;
	}

	/**
	 * Read float.
	 * 
	 * @return the float
	 */
	public static float readFloat() {
		sc.useLocale(Locale.US);
		if (!sc.hasNextFloat()) {
			throw new IllegalArgumentException();
		}
		float num = sc.nextFloat();
		return num;
	}

	/**
	 * Read float overload.
	 * 
	 * @param stream
	 *            fake console input
	 * @return the float
	 */
	public static float readFloat(InputStream stream) {
		sc = new Scanner(stream);
		sc.useLocale(Locale.US);
		if (!sc.hasNextFloat()) {
			throw new IllegalArgumentException();
		}
		float num = sc.nextFloat();
		return num;
	}
}
