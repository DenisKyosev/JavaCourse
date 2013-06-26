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

	/** The online file. */
	private URL onlineFile = null;

	/** The connection. */
	private URLConnection connection = null;

	/** The url. */
	private String url;

	/** The in. */
	private BufferedInputStream in = null;

	/** The out. */
	private BufferedOutputStream out = null;

	/** The file size. */
	private int fileSize;

	/** The destination file. */
	private File dest;

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
		url = download.getSource().getText();

		if (connect()) {
			fileSize = connection.getContentLength();
			if (destinationConnect()) {
				download();
			}
		}

	}

	/**
	 * Try to make new file with given name.
	 * 
	 * @return true, if successful
	 */
	boolean destinationConnect() {

		dest = new File(download.getDestination().getText() + getExtension(onlineFile.toString()));
		try {
			out = new BufferedOutputStream(new FileOutputStream(dest));

			return true;
		} catch (FileNotFoundException e1) {
			DownloaderWindow.getErrorField().setText("Can't open stream.");
			return false;

		}
	}

	/**
	 * Try to download file.
	 * 
	 * @return true, if successful
	 */
	boolean download() {
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
			return true;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * Connect to online source.
	 * 
	 * @return true, if successful
	 */
	boolean connect() {
		try {
			onlineFile = new URL(url);
			connection = onlineFile.openConnection();
			in = new BufferedInputStream(connection.getInputStream());
			return true;
		} catch (IOException e1) {
			DownloaderWindow.getErrorField().setText(
					"Wrong source url or could not open connection!");
			return false;
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
