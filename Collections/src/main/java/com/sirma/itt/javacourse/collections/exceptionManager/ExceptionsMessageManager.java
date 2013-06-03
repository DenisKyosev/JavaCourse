package com.sirma.itt.javacourse.collections.exceptionManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class ExceptionsMessageManager.
 */
public class ExceptionsMessageManager {

	private Map<String, String> exceptions = new HashMap<String, String>();

	private final String separator = "|";

	private String message = "";

	private boolean firstElement = true;

	/**
	 * Instantiates a new exceptions message manager.
	 */
	protected ExceptionsMessageManager() {
		exceptions.put("WrongCardID", "Invalid ID");
		exceptions.put("WrongID", "Invalid ID");
		exceptions.put("WrongPostID", "Wrong ID");
	}

	/**
	 * Adds the exception message.
	 * 
	 * @param mess
	 *            the message
	 * @throws Exception
	 *             exception
	 */
	protected void addExceptionMessage(String mess) throws Exception {
		if (!exceptions.values().contains(mess)) {
			throw new Exception("Message already exists");
		} else {
			if (firstElement) {
				message += mess;
				firstElement = false;
			} else {
				message += separator + mess;
			}
		}
	}

	/**
	 * Adds the exception message using code.
	 * 
	 * @param messageCode
	 *            the message code
	 * @throws Exception
	 *             exception
	 */
	protected void addExceptionMessageUsingCode(String messageCode) throws Exception {
		if (!exceptions.containsKey(messageCode)) {
			throw new Exception("Code doesn't exist");
		} else {
			if (firstElement) {
				firstElement = false;
				message += exceptions.get(messageCode);
			} else {
				message += separator + exceptions.get(messageCode);
			}

		}
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}

	/**
	 * Gets the messages.
	 * 
	 * @param messagesCombination
	 *            the messages
	 * @return the messages as collection
	 */
	Collection<String> getMessages(String messagesCombination) {
		String[] messages = messagesCombination.split(separator);
		return Arrays.asList(messages);
	}

	/**
	 * Getter method for exceptions.
	 * 
	 * @return the exceptions
	 */
	protected Map<String, String> getExceptions() {
		return exceptions;
	}

	/**
	 * Setter method for exceptions.
	 * 
	 * @param exceptions
	 *            the exceptions to set
	 */
	protected void setExceptions(Map<String, String> exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * Getter method for firstElement.
	 * 
	 * @return the firstElement
	 */
	protected boolean isFirstElement() {
		return firstElement;
	}

	/**
	 * Setter method for firstElement.
	 * 
	 * @param firstElement
	 *            the firstElement to set
	 */
	protected void setFirstElement(boolean firstElement) {
		this.firstElement = firstElement;
	}

	/**
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	protected void setMessage(String message) {
		this.message = message;
	}
}
