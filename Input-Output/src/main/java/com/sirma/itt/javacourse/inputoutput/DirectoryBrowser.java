package com.sirma.itt.javacourse.inputoutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Class DirectoryBrowser.
 */
public class DirectoryBrowser {

	/**
	 * Make list content of directory.
	 * 
	 * @param path
	 *            the path
	 * @return message or content
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String makeListContent(String path) throws IOException {
		if (path == null) {
			return "Path does not exist.";
		}
		Path path2 = Paths.get(path);
		File file = new File(path);
		String out = "";
		if (Files.exists(path2)) {
			if (file.isDirectory()) {
				DirectoryStream<Path> stream = Files.newDirectoryStream(path2);
				for (Path file2 : stream) {
					out += file2.getFileName() + "\n";
				}

				return out;
			} else {
				return "it's a file";
			}

		} else {
			return "Path does not exist.";
		}
	}

	/**
	 * List content of directory.
	 * 
	 * @param path
	 *            the path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void listContent(String path) throws IOException {
		System.out.println(makeListContent(path));
	}
}
