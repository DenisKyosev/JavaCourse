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
		if (componentsFlags.containsKey(component)) {
			componentsFlags.put(component, false);
			String result = componentsUpdateText.get(component);
			componentsUpdateText.put(component, "");
			return result;
		} else {
			return "";
		}
	}

	/**
	 * Gets the components flags.
	 * 
	 * @param component
	 *            the component
	 * @return the components flags
	 */
	public boolean getComponentsFlags(String component) {
		return componentsFlags.containsKey(component) && componentsFlags.get(component);
	}

	/**
	 * Sets the text to be updated.
	 * 
	 * @param component
	 *            the component
	 * @param newText
	 *            the new text
	 */
	public void setTextToBeUpdated(String component, String newText) {
		if (componentsFlags.containsKey(component)) {
			StringBuilder string = new StringBuilder();

			if ("Main area".equals(component)) {
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

				string.append(format.format(date));
				string.append(newText);
				string.append("\r\n");

			} else {
				string.append(newText);
			}

			if (componentsFlags.get(component)) {
				string.insert(0, componentsUpdateText.get(component));
				componentsUpdateText.put(component, string.toString());
			} else {
				componentsFlags.put(component, true);
				componentsUpdateText.put(component, string.toString());
			}
		}
	}
}
