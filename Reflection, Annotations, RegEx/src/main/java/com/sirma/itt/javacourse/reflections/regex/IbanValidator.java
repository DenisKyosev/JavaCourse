package com.sirma.itt.javacourse.reflections.regex;

// TODO: Auto-generated Javadoc
/**
 * IbanValidator.
 */
public class IbanValidator {

	/**
	 * Validate.
	 * 
	 * @param iban
	 *            old ibans
	 * @return new ibans
	 */
	public String validate(String iban) {
		String pattern = "(BG)([0-9]{2} )(BNBG )([0-9]{4} )([0-9]{4} )([0-9]{4} )";
		String newIban = iban.replaceAll(pattern, "****");

		return newIban;
	}
}
