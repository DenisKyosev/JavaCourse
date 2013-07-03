package com.sirma.itt.javacourse.netAndGui.task5;

// TODO: Auto-generated Javadoc
/**
 * server closed exception.
 */
public class NoSocketException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Constructor.
	 */
	public NoSocketException() {
		super("Server socket is closed");
	}

	/**
	 * The Constructor.
	 * 
	 * @param message
	 *            the message
	 */
	public NoSocketException(String message) {
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
	public NoSocketException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * The Constructor.
	 * 
	 * @param cause
	 *            the cause
	 */
	public NoSocketException(Throwable cause) {
		super(cause);
	}

}
