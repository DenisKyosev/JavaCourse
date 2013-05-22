package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class TestExceptionsMessageManager.
 */
public class TestExceptionsMessageManager {

	/**
	 * Test message add.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testMessageAdd() throws Exception {
		ExceptionsMessageManager exc = new ExceptionsMessageManager();
		assertEquals("", exc.getMessage());

		exc.addExceptionMessage("hello");
		assertEquals("hello", exc.getMessage());

	}

	/**
	 * Test exception.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		ExceptionsMessageManager exc2 = new ExceptionsMessageManager();
		exc2.addExceptionMessageUsingCode("hey");

		exc2.addExceptionMessageUsingCode("Wrong ID");
		assertEquals("Invalid ID", exc2.getMessage());

		exc2.addExceptionMessage("buu");
		assertEquals("Invalid ID|buu", exc2.getMessage());
	}

}
