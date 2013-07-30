package com.sirma.itt.javacourse.chat.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import com.sirma.itt.javacourse.chat.controllers.InterfaceUpdater;
import com.sirma.itt.javacourse.chat.controllers.LanguageController;
import com.sirma.itt.javacourse.chat.controllers.ServerConnector;
import com.sirma.itt.javacourse.chat.controllers.ServerMessenger;

public class ServerWindow extends JFrame implements ActionListener, Runnable {
	JTextArea txtArea;
	InterfaceUpdater msg;
	ServerSocket server;
	JButton editConfig;
	LanguageController lang;
	boolean closed = false;
	JButton close;

	ServerWindow() {
		msg = new InterfaceUpdater();
		lang = new LanguageController(msg);
		ServerConnector connector = new ServerConnector(msg);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 600);
		Container mainPanel = getContentPane();
		JPanel panel = new JPanel();
		mainPanel.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		txtArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtArea);
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 300;
		c.weightx = 0.7;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 0;
		DefaultCaret caret = (DefaultCaret) txtArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroll, c);
		txtArea.setFocusable(false);

		close = new JButton("Close server");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.gridwidth = 1;
		c.weighty = 0.01;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(close, c);
		close.addActionListener(this);

		editConfig = new JButton("Edit settings");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.gridx = 1;
		c.gridwidth = 1;
		c.weighty = 0.01;
		c.gridy = 1;
		panel.add(editConfig, c);
		editConfig.addActionListener(this);

		String[] users = { "1", "2" };
		JList userslList = new JList(users);
		userslList.setBorder(BorderFactory.createTitledBorder("Online users"));
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 300;
		c.gridx = 1;
		c.weighty = 0.1;
		c.gridy = 0;
		panel.add(userslList, c);
		setVisible(true);

		msg.newComponent("Main area");
		msg.setTextToBeUpdated("Main area", lang.getValue("serverStarted"));

		server = connector.openServerSocket();
		ServerMessenger messenger = null;
		try {
			messenger = new ServerMessenger(server.accept());
		} catch (IOException e) {
			e.printStackTrace();
		}
		msg.setTextToBeUpdated("Main area", messenger.receive());
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editConfig) {
			new ServerSettings();
		}
		if (e.getSource() == close) {
			dispose();
			System.exit(0);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (msg.getComponentsFlags("Main area")) {
				txtArea.append(msg.getUpdatedText("Main area"));
			}
		}
	}

}
