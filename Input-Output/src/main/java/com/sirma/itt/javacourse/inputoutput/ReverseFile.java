package com.sirma.itt.javacourse.inputoutput;

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
	 * @throws IOException
	 *             io exception
	 */
	protected void reverse() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path file = Paths.get("reverse.txt");
		String wholeFile = "";
		String line = "";
		StringBuffer temp = new StringBuffer(wholeFile);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			while ((line = reader.readLine()) != null) {
				temp.append(line);
				temp.append("\n");
			}
		}

		System.out.println(wholeFile);
		temp.delete(temp.length() - 1, temp.length());
		temp.reverse();

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(temp.toString(), 0, temp.length());
		}

	}
}
