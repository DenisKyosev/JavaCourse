package com.sirma.itt.javacourse.chat.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestControllers.
 */
public class TestControllers {

	/**
	 * Test controllers.
	 */
	@Test
	public void testControllers() {
		Wrapper wrap = new Wrapper();
		// TEST CONNECTOR
		assertEquals(true, wrap.getConnector().getSettings());
		assertEquals(true, wrap.getConnector().openServerSocket());

		assertEquals(false, wrap.getConnector().openServerSocket());

		// TEST INTERFACE UPDATER
		assertEquals("", wrap.getMsg().getUpdatedText("test"));
		assertEquals(false, wrap.getMsg().getComponentsFlags("test"));

		wrap.getMsg().newComponent("test");

		assertEquals("", wrap.getMsg().getUpdatedText("test"));
		wrap.getMsg().setTextToBeUpdated("test", "test text\r\n");
		assertEquals(true, wrap.getMsg().getComponentsFlags("test"));

		assertEquals("test text\r\n", wrap.getMsg().getUpdatedText("test"));
		assertEquals(false, wrap.getMsg().getComponentsFlags("test"));

		assertEquals("", wrap.getMsg().getUpdatedText("test"));

		// TEST LANGUAGE CONTROLLER
		assertEquals("Host:", wrap.getLang().getValue("host"));
		wrap.getLang().setLanguage("bulgarian");
		assertEquals("bulgarian", wrap.getLang().getLanguage());
		assertEquals("Хост:", wrap.getLang().getValue("host"));
	}
}
