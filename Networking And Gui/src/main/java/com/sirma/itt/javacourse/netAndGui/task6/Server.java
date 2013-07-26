package com.sirma.itt.javacourse.netAndGui.task6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.netAndGui.connect.Connect;

// TODO: Auto-generated Javadoc
/**
 * Server GUI.
 */
public class Server extends JFrame implements ActionListener, Runnable {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The text area. */
	private static JTextArea txtArea;

	/** The server. */
	private final ServerSocket server;

	/** The msg. */
	private final Messenger msg;

	/** The channel. */
	private final JTextField channel;

	/**
	 * Gets the txt area.
	 * 
	 * @return the txt area
	 */
	protected static JTextArea getTxtArea() {
		return txtArea;
	}

	/** The listen. */
	private final NewClientsListener listen;

	/** The clients. */
	private final Mediator clients;

	/**
	 * Instantiates a new server.
	 */
	Server() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 700, 650);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(inputField);

		txtArea = new JTextArea();
		txtArea.setFocusable(false);
		JButton close = new JButton("Close server");
		close.addActionListener(this);

		inputField.add(txtArea);

		JPanel sendField = new JPanel(new GridLayout(0, 2));
		inputField.add(sendField, BorderLayout.SOUTH);

		channel = new JTextField();
		JButton send = new JButton("Send");
		JLabel channelLabel = new JLabel("Enter channel from 1 to 10:");

		sendField.add(channelLabel);
		sendField.add(channel);
		sendField.add(send);
		sendField.add(close);
		send.addActionListener(this);

		setVisible(true);

		msg = new Messenger();

		msg.setServerMessage("Trying to launch server\r\n");

		server = Connect.openServerSocket();
		if (server != null) {
			msg.setServerMessage("Server started on port: " + server.getLocalPort()
					+ "\r\nWaiting for clients\r\n");
		}

		clients = new Mediator();
		listen = new NewClientsListener(server, clients, msg);
		Thread thread = new Thread(this);
		thread.start();
		thread = new Thread(listen);
		thread.start();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Close server".equals(e.getActionCommand())) {
			try {
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.exit(1);
		} else if ("Send".equals(e.getActionCommand())) {
			try {
				clients.sendMessage(Integer.parseInt(channel.getText()));
			} catch (NumberFormatException e2) {
				msg.setServerMessage("Wrong channel entered\r\n");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (msg.isUpdateServer()) {
				txtArea.setText(msg.getServerMessage());
			}
		}
	}
}