package com.sirma.itt.javacourse.inputoutput;

import java.io.IOException;

/**
 * run Class for DataClass.
 */
public final class RunDataClass {

	/**
	 * Instantiates a new run data class.
	 */
	private RunDataClass() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataClass writer = new DataClass();
		String path = "X:/WORK/JAVA/Sirma/hello.txt";
		UserDefinedObject obj = new UserDefinedObject("HELLO");
		writer.saveObject(path, obj);
		System.out.println(writer.getObject(path));
	}

}
