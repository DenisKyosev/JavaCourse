package com.sirma.itt.javacourse.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The Class DataClass.
 */
public class DataClass {

	/**
	 * Save object.
	 * 
	 * @param path
	 *            the path
	 * @param o
	 *            the o
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveObject(String path, UserDefinedObject o) throws IOException {
		File file = new File(path);
		@SuppressWarnings("resource")
		FileOutputStream fileOut = new FileOutputStream(file, true);
		if (file.exists()) {
			@SuppressWarnings("resource")
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(o);
		} else {
			throw new FileNotFoundException();
		}
	}

	/**
	 * Gets the User Defined Object.
	 * 
	 * @param path
	 *            the path
	 * @return the object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public UserDefinedObject getObject(String path) throws IOException, ClassNotFoundException {
		File file = new File(path);
		@SuppressWarnings("resource")
		FileInputStream fileIn = new FileInputStream(file);
		UserDefinedObject userObj = null;
		if (file.exists()) {
			@SuppressWarnings("resource")
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			userObj = (UserDefinedObject) objIn.readObject();
		} else {
			throw new FileNotFoundException();
		}
		return userObj;
	}
}
