package com.sirma.itt.javacourse.netAndGui.task5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
	private final Messenger msg = new Messenger();

	/**
	 * Gets the txt area.
	 * 
	 * @return the txt area
	 */
	protected static JTextArea getTxtArea() {
		return txtArea;
	}

	/** The server. */
	private final ServerFunctions server;

	/**
	 * Instantiates a new server.
	 */
	Server() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 700, 750);
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

		new Thread(this).start();

		server = new ServerFunctions(msg);
		server.openConnection();
		new Thread(server).start();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Close server".equals(e.getActionCommand())) {
			server.closeServer();
			System.exit(1);
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			if (msg.serverTextAreaChanged()) {
				txtArea.append(msg.getServerTextArea());
			}
		}
	}
}