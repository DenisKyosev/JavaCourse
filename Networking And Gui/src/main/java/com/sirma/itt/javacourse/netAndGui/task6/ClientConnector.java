package com.sirma.itt.javacourse.netAndGui.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientConnector {
	BufferedReader reader;
	BufferedWriter writer;
	Socket client;

	ClientConnector(Socket client) {
		this.client = new Socket();
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void send(String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String receive() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void closeClient() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected BufferedReader getReader() {
		return reader;
	}

	protected void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	protected BufferedWriter getWriter() {
		return writer;
	}

	protected void setWriter(BufferedWriter writer) {
		this.writer = writer;
	}
}
