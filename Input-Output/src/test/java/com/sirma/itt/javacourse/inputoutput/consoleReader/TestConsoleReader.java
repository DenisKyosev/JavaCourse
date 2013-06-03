package com.sirma.itt.javacourse.inputoutput.consoleReader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestConsoleReader.
 */
public class TestConsoleReader {
	private final ConsoleReader read = new ConsoleReader();

	/**
	 * Test string reader.
	 */
	@Test
	public void testStringReader() {
		String data = "asd";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals("asd", read.readString());
	}

	/**
	 * Test int reader.
	 */
	@Test
	public void testIntReader() {
		String data = "6";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals(6, read.readInt());
	}

	/**
	 * Test float reader.
	 */
	@Test
	public void testFloatReader() {
		String data = "1.5";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals(1.5, read.readFloat(), 0.0);
	}

	/**
	 * Test char reader.
	 */
	@Test
	public void testCharReader() {
		String data = "ad6";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals('a', read.readChar());
	}

	/**
	 * Test int reader.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIntReaderWrong() {
		String data = "fsefes";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals(6, read.readInt());
	}

	/**
	 * Test float reader.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFloatReaderWrong() {
		String data = "dwadwa";
		read.setSc(new ByteArrayInputStream(data.getBytes()));
		assertEquals(1.5, read.readFloat(), 0.0);
	}

}
