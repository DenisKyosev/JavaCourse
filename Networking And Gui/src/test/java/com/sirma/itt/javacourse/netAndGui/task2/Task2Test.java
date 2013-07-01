package com.sirma.itt.javacourse.netAndGui.task2;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

/**
 * Testing downloader with online and offline file.
 */
public class Task2Test {

	/**
	 * Test downloader.
	 */
	@Test
	public void testDownloader() {
		Download download = new Download(new DownloaderWindow());

		String test = "X:\\asd.mkv";
		assertEquals(false, download.destinationConnect(test));

		test = "C:\\asd.mkv";
		assertEquals(true, download.destinationConnect(test));

		// existing file
		test = "http://middleages-bg.info/aaa.mkv";
		assertEquals(true, download.connect(test));

		// not existing file
		test = "http://middleages-bg.info/asasaaa.mkv";
		assertEquals(false, download.connect(test));

		test = "http://middleages-bg.info/aaa.mkv";
		assertEquals(true, download.connect(test));

		String dest = "C:\\asd.mkv";
		String source = "http://middleages-bg.info/aaa.mkv";

		assertEquals(true, download.download(source, dest));

		File downloaded = new File("C:\\asd.mkv");
		assertEquals(49330329, downloaded.length());

		Download download2 = new Download(new DownloaderWindow());

		source = "file:///C:\\asd.mkv";
		dest = "C:\\asd2.mkv";
		assertEquals(true, download2.download(source, dest));

		File downloaded2 = new File("C:\\asd2.mkv");
		assertEquals(49330329, downloaded2.length());

		downloaded.delete();
		downloaded2.delete();
	}
}
