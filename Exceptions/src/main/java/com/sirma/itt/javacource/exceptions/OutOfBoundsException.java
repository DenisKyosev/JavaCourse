package com.sirma.itt.javacource.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Exception class for our of range number [0-100].
 */
public class OutOfBoundsException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Constructor.
	 */
	public OutOfBoundsException() {
		super("Number out of bounds");
	}

	/**
	 * The Constructor.
	 * 
	 * @param message
	 *            the message
	 */
	public OutOfBoundsException(String message) {
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
	public OutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * The Constructor.
	 * 
	 * @param cause
	 *            the cause
	 */
	public OutOfBoundsException(Throwable cause) {
		super(cause);
	}

}
