package com.sirma.itt.javacourse.inputoutput;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestConsoleReader.
 */
public class TestConsoleReader {

	/**
	 * Test string reader.
	 */
	@Test
	public void testStringReader() {
		String data = "asd";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals("asd", ConsoleReader.readString(is));
	}

	/**
	 * Test int reader.
	 */
	@Test
	public void testIntReader() {
		String data = "6";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals(6, ConsoleReader.readInt(is));
	}

	/**
	 * Test float reader.
	 */
	@Test
	public void testFloatReader() {
		String data = "1.5";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals(1.5, ConsoleReader.readFloat(is), 0.0);
	}

	/**
	 * Test char reader.
	 */
	@Test
	public void testCharReader() {
		String data = "ad6";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals('a', ConsoleReader.readChar(is));
	}

	/**
	 * Test int reader.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIntReaderWrong() {
		String data = "fsefes";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals(6, ConsoleReader.readInt(is));
	}

	/**
	 * Test float reader.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFloatReaderWrong() {
		String data = "dwadwa";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		assertEquals(1.5, ConsoleReader.readFloat(is), 0.0);
	}

}
