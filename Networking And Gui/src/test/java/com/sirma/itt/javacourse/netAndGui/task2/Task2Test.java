package com.sirma.itt.javacourse.netAndGui.task2;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class Task2Test {
	@Test
	public void testDownloader() {
		Download download = new Download(new DownloaderWindow());

		String test = "X:\\asd.exe";
		assertEquals(false, download.destinationConnect(test));

		test = "asd.exe";
		assertEquals(true, download.destinationConnect(test));

		// existing file
		test = "http://middleages-bg.info/aaa.mkv";
		assertEquals(true, download.connect(test));

		// not existing file
		test = "http://middleages-bg.info/asasaaa.mkv";
		assertEquals(false, download.connect(test));

		test = "http://middleages-bg.info/aaa.mkv";
		assertEquals(true, download.connect(test));

		String dest = "asd.mkv";
		String source = "http://middleages-bg.info/aaa.mkv";

		assertEquals(true, download.download(source, dest));

		File downloaded = new File("asd.mkv");
		assertEquals(49330329, downloaded.length());

		downloaded.delete();
	}
}
