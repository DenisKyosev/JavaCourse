package com.sirma.itt.javacourse.chat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.clientfunctions.ClientFunctions;
import com.sirma.itt.javacourse.chat.controllers.ClientConnector;
import com.sirma.itt.javacourse.chat.controllers.InterfaceUpdater;

public class ClientLoginWindow extends JFrame implements ActionListener {
	JTextField host;
	JTextField port;
	JTextField username;
	JButton connect;
	JButton cancel;
	ClientConnector connector;
	InterfaceUpdater msg;
	Socket client;
	ClientFunctions function = new ClientFunctions();

	ClientLoginWindow(InterfaceUpdater msg, Socket client) {
		this.msg = msg;
		this.client = client;
		connector = new ClientConnector(msg);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 200, 300, 150);
		Container mainPanel = getContentPane();

		JPanel editField = new JPanel(new GridLayout(4, 2));
		host = new JTextField("localhost");
		port = new JTextField("7000");
		username = new JTextField();
		connect = new JButton("Connect");
		cancel = new JButton("Cancel");

		editField.add(new JLabel("Host:"));
		editField.add(host);

		editField.add(new JLabel("Port:"));
		editField.add(port);

		editField.add(new JLabel("Nickname:"));
		editField.add(username);

		editField.add(cancel);
		editField.add(connect);
		connect.addActionListener(this);
		cancel.addActionListener(this);

		editField.setBorder(BorderFactory.createTitledBorder("Login"));

		mainPanel.setBackground(Color.GREEN);
		mainPanel.add(editField, BorderLayout.CENTER);
		getSettings();

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			try {
				client = connector.openSocket(host.getText(), Integer.parseInt(port.getText()),
						username.getText());
				function.saveSettings(host.getText(), port.getText(), username.getText());
				if (client != null) {
					msg.setTextToBeUpdated("Main area", msg.getText("connectionSuccess"));
				} else {
					msg.setTextToBeUpdated("Main area", msg.getText("connectionFail"));
				}
				dispose();
			} catch (NumberFormatException e2) {
				msg.setTextToBeUpdated("Main area", msg.getText("wrongPortError"));
			}

		}
		if (e.getSource() == cancel) {
			dispose();
		}
	}

	private void getSettings() {
		host.setText(function.getSettings("host"));
		port.setText(function.getSettings("port"));
		username.setText(function.getSettings("lastUsedUsername"));
	}
}
