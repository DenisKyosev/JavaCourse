package com.sirma.itt.javacourse.designpatterns.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculatorTest.
 */
public class CalculatorTest {

	/**
	 * Test calculator.
	 */
	@Test
	public void testCalculator() {
		Calculate calc = new Calculate();
		CommandInvoker invoke = new CommandInvoker();

		assertEquals(16.0, invoke.execute("4^2", calc), 0.1);
		assertEquals(1.0, invoke.execute("4/2/2", calc), 0.1);
		assertEquals(3.0, invoke.execute("4-1", calc), 0.1);
		assertEquals(84.0, invoke.execute("4*3*7", calc), 0.1);
	}

	/**
	 * Test wrong data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWrongData() {
		Calculate calc = new Calculate();
		CommandInvoker invoke = new CommandInvoker();

		assertEquals(16.0, invoke.execute("4554grrf", calc), 0.1);

	}
}
