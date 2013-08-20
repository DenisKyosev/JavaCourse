package com.sirma.itt.javacourse.chat.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceUpdater.
 */
public class InterfaceUpdater {

	/** The components flags. */
	private final Map<String, Boolean> componentsFlags = new HashMap<String, Boolean>();

	/** The components update text. */
	private final Map<String, String> componentsUpdateText = new HashMap<String, String>();

	/** The language. */
	private String lang;

	/**
	 * Register new component.
	 * 
	 * @param component
	 *            the component
	 */
	public void newComponent(String component) {
		componentsFlags.put(component, false);
		componentsUpdateText.put(component, "");
	}

	/**
	 * Gets the updated text.
	 * 
	 * @param component
	 *            the component
	 * @return the updated text
	 */
	public String getUpdatedText(String component) {
		componentsFlags.put(component, false);
		String result = componentsUpdateText.get(component);
		componentsUpdateText.put(component, "");
		return result;
	}

	/**
	 * Checks for update.
	 * 
	 * @param component
	 *            the component
	 * @return true, if successful
	 */
	public boolean hasUpdate(String component) {
		return componentsFlags.containsKey(component) && componentsFlags.get(component);
	}

	/**
	 * Sets the component and text to be updated.
	 * 
	 * @param component
	 *            the component
	 * @param newText
	 *            the new text
	 */
	public void setTextToBeUpdated(String component, String newText) {
		if (componentsFlags.containsKey(component)) {
			String result = "";
			if ("Main area".equals(component)) {
				result = timeBuilder() + newText;
			} else {
				result = newText;
			}

			if (componentsFlags.get(component)) {
				componentsUpdateText.put(component, componentsUpdateText.get(component) + result
						+ "\r\n");
			} else {
				componentsUpdateText.put(component, result + "\r\n");
				componentsFlags.put(component, true);
			}

		}
	}

	/**
	 * Gets the lang.
	 * 
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Time builder.
	 * 
	 * @return the string
	 */
	public String timeBuilder() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

		return format.format(date);
	}
}
