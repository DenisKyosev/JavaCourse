package com.sirma.itt.javacourse.inputoutput.writeInFile;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
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

	private final WriteInFile fileWrite = new WriteInFile();

	/**
	 * Test string reader.
	 * 
	 * @throws IOException
	 *             io exception
	 */
	@Test
	public void testFileWrite() throws IOException {
		String file = "asd.txt";
		String file2 = "test.txt";
		String data = file + "\r\n asd awda wddwa  wad\r\n assa \r\n.";
		String dataExpected = " asd awda wddwa  wad assa ";
		fileWrite.setSc(new ByteArrayInputStream(data.getBytes()));
		fileWrite.write();

		List<String> actual = null;

		actual = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);

		FileWriter fw = new FileWriter(file2);
		fw.append(dataExpected);
		fw.close();

		List<String> expected = null;

		expected = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);

		assertEquals("The files differ!", expected, actual);
	}
}
