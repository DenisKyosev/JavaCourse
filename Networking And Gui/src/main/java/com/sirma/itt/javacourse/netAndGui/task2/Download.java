package com.sirma.itt.javacourse.netAndGui.task2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// TODO: Auto-generated Javadoc
/**
 * File download performer. Launches on click of the download button.
 */
public class Download implements Runnable {

	/** The online file. */
	private URL onlineFile = null;

	/** The connection. */
	private URLConnection connection = null;

	/** The in. */
	private BufferedInputStream in = null;

	/** The out. */
	private BufferedOutputStream out = null;

	/** The file size. */
	private int fileSize;

	/** The destination text. */
	private String destination = null;

	/** The source. */
	private final String source;

	/** The messenger. */
	private final Messenger msg;

	/** The destination file. */
	private File destinationFile;

	/**
	 * Instantiates a new download.
	 * 
	 * @param source
	 *            the source
	 * @param destination
	 *            the destination
	 * @param msg
	 *            the msg
	 */
	public Download(String source, String destination, Messenger msg) {
		this.source = source;
		this.destination = destination;
		this.msg = msg;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		msg.setErrorMessage("");
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

		if (destinationFile == null) {
			destinationFile = new File(destination + getExtension(source.toString()));
		}
		try {
			out = new BufferedOutputStream(new FileOutputStream(destinationFile));
			return true;
		} catch (FileNotFoundException e1) {
			msg.setErrorMessage("Can't open stream.");
			return false;

		}
	}

	/**
	 * Destination connect.
	 * 
	 * @param path
	 *            the path
	 * @return true, if successful
	 */
	boolean destinationConnect(String path) {
		destinationFile = new File(path);
		return destinationConnect();
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

			// download.getProgress().setMaximum(fileSize);
			msg.setMaxProgressValue(fileSize);
			while (len > 0) {
				out.write(buf, 0, len);
				len = in.read(buf);
				readed += len;
				msg.setProgressValue(readed);

			}
			msg.setErrorMessage("File downloaded successfully");
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
	 * Download file.
	 * 
	 * @param source
	 *            the source
	 * @param dest
	 *            the destination
	 * @return true, if successful
	 */
	boolean download(String source, String dest) {
		connect(source);
		destinationConnect(dest);
		return download();
	}

	/**
	 * Connect to online source.
	 * 
	 * @return true, if successful
	 */
	boolean connect() {
		boolean error = false;
		if (onlineFile == null) {
			try {
				onlineFile = new URL(source);
			} catch (IOException e1) {
				error = true;
			}
		}
		if (!error) {
			try {
				connection = onlineFile.openConnection();
				in = new BufferedInputStream(connection.getInputStream());
			} catch (IOException e) {
			}
		} else {
			msg.setErrorMessage("Wrong source url or could not open connection!");
		}
		return !error;

	}

	/**
	 * Connect to source.
	 * 
	 * @param url
	 *            the url
	 * @return true, if successful
	 */
	boolean connect(String url) {
		try {
			onlineFile = new URL(url);
		} catch (MalformedURLException e) {
			return false;
		}
		return connect();
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
