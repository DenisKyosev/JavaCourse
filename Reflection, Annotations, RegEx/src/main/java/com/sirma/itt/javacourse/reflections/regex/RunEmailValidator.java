package com.sirma.itt.javacourse.reflections.regex;

/**
 * RunEmailValidator.
 */
public final class RunEmailValidator {

	/**
	 * Instantiates a new run email validator.
	 */
	private RunEmailValidator() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EmailValidator validate = new EmailValidator();
		String mail = "test.t-s@sir-ma.com";
		System.out.println(validate.validate(mail));

	}

}
