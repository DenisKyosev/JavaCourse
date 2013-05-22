package com.sirma.itt.javacource.exceptions;

// TODO: Auto-generated Javadoc
/**
 * array is empty exception.
 */
public class ArrayIsEmptyException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Constructor.
	 */
	public ArrayIsEmptyException() {
		super("Array is empty");
	}

	/**
	 * The Constructor.
	 * 
	 * @param message
	 *            the message
	 */
	public ArrayIsEmptyException(String message) {
		super(message);
	}

	/**
	 * The Constructor.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ArrayIsEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * The Constructor.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ArrayIsEmptyException(Throwable cause) {
		super(cause);
	}

}
