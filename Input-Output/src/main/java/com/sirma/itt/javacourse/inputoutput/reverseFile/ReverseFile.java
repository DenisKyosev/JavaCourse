package com.sirma.itt.javacourse.inputoutput.reverseFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Class ReverseFile.
 */
public class ReverseFile {

	/**
	 * Reverse.
	 * 
	 * @param str
	 *            path to file
	 * @throws IOException
	 *             io exception
	 */
	public void reverse(String str) throws IOException {
		Path file = Paths.get(str);
		if (!Files.exists(file)) {
			throw new IllegalArgumentException("No such file");
		}
		if (!Files.isReadable(file)) {
			throw new IllegalArgumentException("File not readable");
		}
		Charset charset = Charset.forName("UTF-8");
		// Path file = Paths.get("reverse.txt");
		String wholeFile = "";
		String line = "";
		StringBuffer temp = new StringBuffer(wholeFile);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			while ((line = reader.readLine()) != null) {
				temp.append(line);
				temp.append("\n");
			}
			reader.close();
		}

		System.out.println(wholeFile);
		temp.delete(temp.length() - 1, temp.length());
		temp.reverse();

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(temp.toString(), 0, temp.length());
			writer.close();
		}

	}
}
