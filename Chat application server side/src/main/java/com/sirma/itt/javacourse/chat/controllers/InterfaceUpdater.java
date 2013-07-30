package com.sirma.itt.javacourse.chat.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InterfaceUpdater {
	private final Map<String, Boolean> componentsFlags = new HashMap<String, Boolean>();
	private final Map<String, String> componentsUpdateText = new HashMap<String, String>();

	public void newComponent(String component) {
		componentsFlags.put(component, false);
		componentsUpdateText.put(component, "");
	}

	public String getUpdatedText(String component) {
		if (componentsFlags.containsKey(component)) {
			componentsFlags.put(component, false);
			return componentsUpdateText.get(component);
		} else {
			return "";
		}
	}

	public boolean getComponentsFlags(String component) {
		return componentsFlags.get(component);
	}

	public void setTextToBeUpdated(String component, String newText) {
		if (componentsFlags.containsKey(component)) {
			StringBuilder string = new StringBuilder();
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

			string.append(format.format(date));
			string.append(newText);
			string.append("\r\n");

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
