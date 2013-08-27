package com.sirma.itt.javacourse.chat.clientfunctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sirma.itt.javacourse.chat.controllers.InterfaceUpdater;
import com.sirma.itt.javacourse.chat.controllers.LanguageController;

// TODO: Auto-generated Javadoc
/**
 * The Class Logger.
 */
public class Logger {

	/** The msg. */
	private final InterfaceUpdater msg;

	/** The lang. */
	private final LanguageController lang;
	/** The log file writer. */
	private FileWriter writer;

	/**
	 * Instantiates a new logger. Creates directory "log" and log file by date.
	 * 
	 * @param msg
	 *            the msg
	 * @param lang
	 *            the lang
	 */
	public Logger(InterfaceUpdater msg, LanguageController lang) {
		this.msg = msg;
		this.lang = lang;
	}

	/**
	 * Creates the log file.
	 * 
	 * @param username
	 *            the username
	 */
	public void createLogFile(String username) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder fileName = new StringBuilder();
		fileName.append("logs/");
		fileName.append(format.format(date));
		fileName.append("-");
		fileName.append(username);
		fileName.append(".txt");
		try {
			File dir = new File("logs");
			if (!dir.exists()) {
				dir.mkdir();
			}
			File file = new File(fileName.toString());
			if (file.exists()) {
				writer = new FileWriter(file, true);
			} else {
				file.createNewFile();
				writer = new FileWriter(file, true);
			}
		} catch (IOException e) {
			msg.setTextToBeUpdated("Main area", lang.getValue("logFileError"));
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
			msg.setTextToBeUpdated("Main area", lang.getValue("logFileError"));
		}
	}
}
