package com.sirma.itt.javacourse.chat.clientfunctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Logger.
 */
public class Logger {

	/** The wrapper. */
	private final Wrapper wrap;

	/** The log file writer. */
	private FileWriter writer;

	/**
	 * Instantiates a new logger. Creates directory "log" and log file by date.
	 * 
	 * @param wrap
	 *            the wrapper
	 */
	public Logger(Wrapper wrap) {
		this.wrap = wrap;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fileName = "logs/" + format.format(date) + ".txt";

		try {
			File dir = new File("logs");
			if (!dir.exists()) {
				dir.mkdir();
			}
			File file = new File(fileName);
			if (file.exists()) {
				writer = new FileWriter(file, true);
			} else {
				file.createNewFile();
				writer = new FileWriter(file, true);
			}
		} catch (IOException e) {
			wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("logFileError"));
		}
	}

	/**
	 * Log message.
	 * 
	 * @param message
	 *            the message
	 */
	public void log(String message) {
		try {
			writer.append(message);
			writer.flush();
		} catch (IOException e) {
			wrap.getMsg().setTextToBeUpdated("Main area", wrap.getLang().getValue("logFileError"));
		}
	}
}
