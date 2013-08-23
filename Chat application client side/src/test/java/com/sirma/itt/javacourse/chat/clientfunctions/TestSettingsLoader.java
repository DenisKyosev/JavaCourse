package com.sirma.itt.javacourse.chat.clientfunctions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSettingsLoader.
 */
public class TestSettingsLoader {
	
	/**
	 * Test settings.
	 */
	@Test
	public void testSettings() {
		Settings settings = new Settings();
		assertEquals("yourName", settings.getSettings("lastUsedUsername"));
		assertEquals("7000", settings.getSettings("port"));
		assertEquals("localhost", settings.getSettings("host"));
		assertEquals("english", settings.getSettings("lastUsedLanguage"));

		assertEquals(true, settings.saveSettings("127.0.0.1", "7001", "yourUsername"));

		assertEquals("yourUsername", settings.getSettings("lastUsedUsername"));
		assertEquals("7001", settings.getSettings("port"));
		assertEquals("127.0.0.1", settings.getSettings("host"));
		assertEquals("english", settings.getSettings("lastUsedLanguage"));
	}
}
