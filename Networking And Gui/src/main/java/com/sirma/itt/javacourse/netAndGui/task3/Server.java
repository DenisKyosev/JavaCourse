package com.sirma.itt.javacourse.netAndGui.task3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The client socket. */
	private Socket client;

	/** The text area. */
	private final JTextArea txtArea;
	private boolean closed = false;
	private final JButton close;

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
		close = new JButton("Close server");
		close.addActionListener(this);

		inputField.add(txtArea);
		inputField.add(close, BorderLayout.SOUTH);
		setVisible(true);
		txtArea.append("Trying to launch server\r\n");

		ServerFunctions server = new ServerFunctions();

		txtArea.append(server.serverStarted());
		while (!closed) {
			txtArea.append(server.sendMessage(client));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Close server".equals(e.getActionCommand())) {
			closed = true;
			dispose();
		}
	}
}