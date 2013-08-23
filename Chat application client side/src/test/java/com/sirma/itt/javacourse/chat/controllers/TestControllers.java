package com.sirma.itt.javacourse.chat.controllers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestControllers.
 */
public class TestControllers {

	/** The wrap. */
	private final Wrapper wrap = new Wrapper();

	/**
	 * Test client connector.
	 */
	@Test
	public void testClientConnector() {
		ClientConnector connect = new ClientConnector(wrap);
		@SuppressWarnings("unused")
		ServerSocket dummyServer;

		// TEST CLIENT CONNECTOR
		try {
			dummyServer = new ServerSocket(7020);
		} catch (IOException e) {
		}

		assertEquals(true, connect.openSocket("localhost", 7020));

		// 13 characters test
		assertEquals(false, connect.checkAndSendUsername("festerdrgdrgdrgg"));
		assertEquals(true, connect.checkAndSendUsername("fester"));

		// TEST COMMAND PARSER
		wrap.getMsg().newComponent("Main area");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");

		wrap.getCmdParser().parseCommand("/connected fester");
		String expected = format.format(date) + "New user connected: fester\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));

		wrap.setUsername("fester");
		wrap.getCmdParser().parseCommand("/disconnect fester2");
		expected = format.format(date) + "fester2 left the chat room.\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));

		wrap.getCmdParser().parseCommand("/disconnect fester");
		expected = format.format(date) + "Disconnected from server.\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));

		wrap.getCmdParser().parseCommand("/usernameChange fester-fester2");
		expected = format.format(date) + "fester renamed to: fester2\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));
		assertEquals("fester2", wrap.getUsername());

		wrap.getCmdParser().parseCommand("/usernameUnavailable");
		expected = format.format(date) + "Username already taken choose different one.\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));

		wrap.getCmdParser().parseCommand("/incognito fester");
		expected = format.format(date) + "fester left the chat room.\r\n";
		assertEquals(expected, wrap.getMsg().getUpdatedText("Main area"));

		// TEST INTERFACE UPDATER
		assertEquals(null, wrap.getMsg().getUpdatedText("test"));
		assertEquals(false, wrap.getMsg().hasUpdate("test"));

		wrap.getMsg().newComponent("test");

		assertEquals("", wrap.getMsg().getUpdatedText("test"));
		wrap.getMsg().setTextToBeUpdated("test", "test text");
		assertEquals(true, wrap.getMsg().hasUpdate("test"));

		assertEquals("test text\r\n", wrap.getMsg().getUpdatedText("test"));
		assertEquals(false, wrap.getMsg().hasUpdate("test"));

		assertEquals("", wrap.getMsg().getUpdatedText("test"));

		// TEST LANGUAGE CONTROLLER
		assertEquals("english", wrap.getLang().getLastUsedLanguage());
		assertEquals("Host: ", wrap.getLang().getValue("host"));
		wrap.getLang().setLanguage("bulgarian");
		assertEquals("bulgarian", wrap.getLang().getLanguage());
		assertEquals("Хост: ", wrap.getLang().getValue("host"));

	}
}
