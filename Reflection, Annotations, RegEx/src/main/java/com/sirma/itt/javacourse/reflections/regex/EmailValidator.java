package com.sirma.itt.javacourse.reflections.regex;

import java.util.regex.Pattern;

/**
 * EmailValidator.
 */
public class EmailValidator {

	/**
	 * Validate email.
	 * 
	 * @param email
	 *            the email
	 * @return true, if successful
	 */
	public boolean validate(String email) {
		String pattern = "([a-zA-Z])([a-zA-Z0-9\\.\\-]*)(@)([a-zA-Z])([a-zA-Z0-9\\.\\-]*)";

		return Pattern.matches(pattern, email);
	}
}
