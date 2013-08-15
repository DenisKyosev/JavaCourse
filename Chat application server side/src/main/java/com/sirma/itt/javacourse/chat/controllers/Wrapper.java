package com.sirma.itt.javacourse.chat.controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import com.sirma.itt.javacourse.chat.serverfunctions.ClientsListener;

public class Wrapper {
	InterfaceUpdater msg;
	LanguageController lang;
	ServerConnector connector;
	ServerSocket server;
	Thread thread;
	ArrayList<String> usersList = new ArrayList<String>();

	public ArrayList<String> getUsersList() {
		return usersList;
	}

	protected void setUsersList(ArrayList<String> usersList) {
		this.usersList = usersList;
	}

	public Wrapper() {
		this.connector = new ServerConnector(this);
		this.msg = new InterfaceUpdater();
		this.lang = new LanguageController(msg);

	}

	public void connect() {
		connector.openServerSocket();
		ClientsListener newClientListener = new ClientsListener(this);
		thread = new Thread(newClientListener);
		thread.start();
	}

	public void disconnect() {
		try {
			server.close();
			server = null;
			thread.interrupt();
			this.getMsg().setTextToBeUpdated("Main area", this.getLang().getValue("serverStopped"));
		} catch (IOException e) {
		}
	}

	public ServerSocket getServer() {
		return server;
	}

	protected void setServer(ServerSocket server) {
		this.server = server;
	}

	public InterfaceUpdater getMsg() {
		return msg;
	}

	protected void setMsg(InterfaceUpdater msg) {
		this.msg = msg;
	}

	public LanguageController getLang() {
		return lang;
	}

	public void setLang(LanguageController lang) {
		this.lang = lang;
	}

	public ServerConnector getConnector() {
		return connector;
	}

	protected void setConnector(ServerConnector connector) {
		this.connector = connector;
	}
}
