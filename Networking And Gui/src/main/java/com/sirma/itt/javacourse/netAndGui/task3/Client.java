package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {
	Socket client;
	JTextArea txtArea;

	Client() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(inputField);

		txtArea = new JTextArea();
		txtArea.setFocusable(false);

		inputField.add(txtArea);

		setVisible(true);
		client = openSocket();
		txtArea.append("Client connected to server on port " + Integer.toString(client.getPort())
				+ "\r\n");
		String message;
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while ((message = stream.readLine()) != null) {
				txtArea.append(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Socket openSocket() {
		for (int i = 7000; i < 7020; i++) {
			try {
				return new Socket("localhost", i);
			} catch (IOException e) {
				txtArea.append("No server running on this address/port(" + i + ")\r\n");
			}
		}
		return null;
	}
}