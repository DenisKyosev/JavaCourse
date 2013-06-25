package com.sirma.itt.javacourse.netAndGui.task2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

// TODO: Auto-generated Javadoc
/**
 * File download performer. Launches on click of the download button.
 */
public class Download implements Runnable {

	/** The download. */
	private final DownloaderWindow download;

	/**
	 * Instantiates a new download.
	 * 
	 * @param download
	 *            the download
	 */
	public Download(DownloaderWindow download) {
		this.download = download;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		DownloaderWindow.getErrorField().setText("");
		String url = download.getSource().getText();

		URL onlineFile = null;
		URLConnection connection = null;
		BufferedInputStream in = null;

		try {
			onlineFile = new URL(url);
			connection = onlineFile.openConnection();
			in = new BufferedInputStream(connection.getInputStream());

		} catch (IOException e1) {
			DownloaderWindow.getErrorField().setText(
					"Wrong source url or could not open connection!");
			return;
		}
		int fileSize = connection.getContentLength();
		File dest = new File(download.getDestination().getText()
				+ getExtension(onlineFile.toString()));
		BufferedOutputStream out = null;

		try {
			out = new BufferedOutputStream(new FileOutputStream(dest));
		} catch (FileNotFoundException e1) {
			DownloaderWindow.getErrorField().setText("File system error!");
		}

		int readed = 0;

		byte[] buf = new byte[1024];
		int len;
		try {
			len = in.read(buf);

			download.getProgress().setMaximum(fileSize);

			while (len > 0) {
				out.write(buf, 0, len);
				len = in.read(buf);
				readed += len;
				download.getProgress().setValue(readed);

			}
			download.getProgress().setValue(100);
			DownloaderWindow.getErrorField().setText("File downloaded successfully");
			in.close();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * Gets the extension of a file.
	 * 
	 * @param input
	 *            the input
	 * @return the extension
	 */
	String getExtension(String input) {
		return input.substring(input.lastIndexOf("."));
	}
}
