package com.sirma.itt.javacourse.inputoutput;

import java.io.IOException;

/**
 * run Class for DirectoryBrowser.
 */
public final class RunDirectoryBrowser {

	/**
	 * Instantiates a new run directory browser.
	 */
	private RunDirectoryBrowser() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             io exception
	 */
	public static void main(String[] args) throws IOException {
		DirectoryBrowser dirBrowser = new DirectoryBrowser();
		String path = null;
		dirBrowser.listContent(path);
	}

}
