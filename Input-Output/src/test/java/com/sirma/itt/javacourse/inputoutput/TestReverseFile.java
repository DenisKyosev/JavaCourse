package com.sirma.itt.javacourse.inputoutput;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestReverseFile.
 */
public class TestReverseFile {

	private final ReverseFile rev = new ReverseFile();

	/**
	 * Test reverse file.
	 * 
	 * @throws IOException
	 *             io exception
	 */
	@Test
	public void testReverseFile() throws IOException {
		String file = "reverse.txt";
		String file2 = "reversedTest.txt";

		List<String> actual = null;
		try {
			actual = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> expected = null;
		try {
			expected = Files.readAllLines(Paths.get(file2), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rev.reverse();
		assertEquals("The files differ!", expected, actual);
	}

	/**
	 * Test reverse reversed file.
	 * 
	 * @throws IOException
	 *             io exception
	 */
	@Test
	public void testReverseReversedFile() throws IOException {
		String file = "reverse.txt";
		String file2 = "notReversedTest.txt";

		List<String> actual = null;
		try {
			actual = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> expected = null;
		try {
			expected = Files.readAllLines(Paths.get(file2), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rev.reverse();
		assertEquals("The files differ!", expected, actual);
	}
}
