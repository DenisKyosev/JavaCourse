package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The server socket. */
	private final ServerSocket server;

	/** The client socket. */
	private Socket client;

	/** The text area. */
	private final JTextArea txtArea;

	/**
	 * Instantiates a new server.
	 */
	Server() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(inputField);

		txtArea = new JTextArea();
		txtArea.setFocusable(false);
		JButton close = new JButton("Close server");
		close.addActionListener(this);

		inputField.add(txtArea);
		inputField.add(close, BorderLayout.SOUTH);
		setVisible(true);
		txtArea.append("Trying to launch server\r\n");
		server = Connect.openServerSocket();
		if (server == null) {
			txtArea.append("No available port in range 7000-7020.");
		} else {
			txtArea.append("Server started on port: " + server.getLocalPort()
					+ "\r\nWaiting for clients\r\n");
			while (true) {
				sendMessage(client);
			}
		}
	}

	/**
	 * Send message.
	 * 
	 * @param client
	 *            the client
	 */
	void sendMessage(Socket client) {
		String message = "";
		try {
			client = server.accept();
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			message = "Hello " + Calendar.getInstance().getTime();
			writer.println(message);
			writer.println();
			writer.flush();
			txtArea.append("Client connected. \r\nSent message:" + message + "\r\n");
		} catch (IOException e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Close server".equals(e.getActionCommand())) {
			try {
				server.close();
				dispose();
			} catch (IOException e1) {
			}
		}

	}
}