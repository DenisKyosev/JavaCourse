package com.sirma.itt.javacourse.reflections.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * TestEmailValidator.
 */
public class TestEmailValidator {

	private final EmailValidator validate = new EmailValidator();

	/**
	 * Test email validator.
	 */
	@Test
	public void testValidator() {
		String email = "test.t-s@sir-ma.com";
		assertEquals(true, validate.validate(email));

		email = "h1ello@sirma999.com";
		assertEquals(true, validate.validate(email));

		email = "eee@s-sirma.com";
		assertEquals(true, validate.validate(email));

		email = "eee@cc.british.museum";
		assertEquals(true, validate.validate(email));

		email = "11eee@cc.british.museum";
		assertEquals(false, validate.validate(email));

		email = "eee@cc.british,museum";
		assertEquals(false, validate.validate(email));
	}
}
