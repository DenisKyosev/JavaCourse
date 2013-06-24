package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame {
	ServerSocket socket;
	Socket client;

	Server() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(inputField);

		JTextArea txtArea = new JTextArea();
		txtArea.setFocusable(false);

		inputField.add(txtArea);

		socket = openServerSocket();
		txtArea.append("Server started on port: " + socket.getLocalPort()
				+ " Waiting for clients\r\n");

		setVisible(true);
		String message = "";
		try {
			client = socket.accept();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			message = "Hello " + Calendar.getInstance().getTime();
			writer.write(message);
			txtArea.append("Client connected. Sent message:" + message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	ServerSocket openServerSocket() {
		for (int i = 7000; i <= 7020; i++) {
			try {
				return new ServerSocket(i);
			} catch (IOException ex) {
				continue;
			}
		}
		return null;
	}
}