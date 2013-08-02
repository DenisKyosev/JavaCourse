package com.sirma.itt.javacourse.chat.controllers;

import java.net.Socket;

public class Wrapper {
	ClientConnector connector;
	InterfaceUpdater msg;
	ClientMessenger messenger;
	LanguageController lang;
	Socket client;

	public Wrapper() {
		this.connector = new ClientConnector(this);
		this.msg = new InterfaceUpdater();
		this.lang = new LanguageController(msg);
	}

	public ClientConnector getConnector() {
		return connector;
	}

	protected void setConnector(ClientConnector connector) {
		this.connector = connector;
	}

	public InterfaceUpdater getMsg() {
		return msg;
	}

	protected void setMsg(InterfaceUpdater ui) {
		this.msg = ui;
	}

	public ClientMessenger getMessenger() {
		return messenger;
	}

	public void setMessenger(ClientMessenger messenger) {
		this.messenger = messenger;
	}

	public LanguageController getLang() {
		return lang;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	protected void setLang(LanguageController lang) {
		this.lang = lang;
	}
}
