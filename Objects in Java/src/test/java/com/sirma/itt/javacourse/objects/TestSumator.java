package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.sumator.Sumator;

/**
 * Testing class for sumator.
 * 
 * @author Fester
 */
public class TestSumator {
	private Sumator sm = new Sumator();

	/**
	 * testing int sumator method.
	 */
	@Test
	public void testInts() {
		assertEquals("must be 10", 10, sm.sum(5, 5));
		assertEquals("must be 7", 7, sm.sum(3, 4));
	}

	/**
	 * testing float sumator method.
	 */
	@Test
	public void testFloats() {
		assertEquals(4.0f, sm.sum(2.0f, 2.0f), 0.01);
		assertEquals(6.6f, sm.sum(2.3f, 4.3f), 0.01);
	}

	/**
	 * testing strings sumator method.
	 */
	@Test
	public void testStrings() {
		assertEquals("6", sm.sum("4", "2"));
		assertEquals("22", sm.sum("10", "12"));
	}

	/**
	 * testing strings with null sumator method.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullStrings() {
		sm.sum(null, "");
	}

	/**
	 * testing strings sumator method.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMinusStrings() {
		sm.sum("-10", "21");
	}

	/**
	 * testing Big integer sumator method.
	 */
	@Test
	public void testBigInt() {
		BigInteger bigInt1 = new BigInteger("55");
		BigInteger bigInt2 = new BigInteger("55");
		assertEquals(new BigInteger("110"), sm.sum(bigInt1, bigInt2));
	}

	/**
	 * testing Big decimal sumator method.
	 */
	@Test
	public void testBigDec() {
		BigDecimal bigDec1 = new BigDecimal("55.5");
		BigDecimal bigDec2 = new BigDecimal("55.5");
		assertEquals(new BigDecimal("111.0"), sm.sum(bigDec1, bigDec2));
	}
}
