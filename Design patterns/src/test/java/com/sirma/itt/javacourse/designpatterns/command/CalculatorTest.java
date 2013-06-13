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

		CommandInvoker invoke = new CommandInvoker();

		assertEquals(16.0, invoke.execute("4^2"), 0.1);
		assertEquals(1.0, invoke.execute("4/2/2"), 0.1);
		assertEquals(3.0, invoke.execute("4-1"), 0.1);
		assertEquals(84.0, invoke.execute("4*3*7"), 0.1);
	}

	/**
	 * Test wrong data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWrongData() {

		CommandInvoker invoke = new CommandInvoker();

		assertEquals(16.0, invoke.execute("4554grrf"), 0.1);

	}
}
