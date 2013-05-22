package com.sirma.itt.javacourse.inputoutput;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * Test Class for WriteInFile.
 */
public class TestWriteInFile {

	private WriteInFile fileWrite = new WriteInFile();

	/**
	 * Test string reader.
	 */
	@Test
	public void testFileWrite() {
		String file = "asd.txt";
		String file2 = "test.txt";
		String data = file + "\r\n asd awda wddwa  wad\r\n assa \r\n.";
		String dataExpected = " asd awda wddwa  wad assa ";
		InputStream is = new ByteArrayInputStream(data.getBytes());
		fileWrite.write(is);

		List<String> actual = null;
		try {
			actual = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter(file2);
			fw.append(dataExpected);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> expected = null;
		try {
			expected = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("The files differ!", expected, actual);
	}
}
