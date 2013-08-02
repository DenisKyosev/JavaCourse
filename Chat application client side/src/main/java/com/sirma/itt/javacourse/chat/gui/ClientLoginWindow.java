package com.sirma.itt.javacourse.chat.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.clientfunctions.ClientFunctions;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

public class ClientLoginWindow extends JFrame implements ActionListener {
	JTextField host;
	JTextField port;
	JTextField username;
	JButton connect;
	JButton cancel;

	Wrapper wrap;
	ClientFunctions function = new ClientFunctions();

	ClientLoginWindow(Wrapper wrap) {
		this.wrap = wrap;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500, 500, 300, 150);
		Container mainPanel = getContentPane();

		JPanel editField = new JPanel(new GridLayout(4, 2));
		host = new JTextField("localhost");
		port = new JTextField("7000");
		username = new JTextField();
		connect = new JButton(wrap.getLang().getValue("connect"));
		cancel = new JButton(wrap.getLang().getValue("cancel"));

		editField.add(new JLabel(wrap.getLang().getValue("host")));
		editField.add(host);

		editField.add(new JLabel(wrap.getLang().getValue("port")));
		editField.add(port);

		editField.add(new JLabel(wrap.getLang().getValue("username")));
		editField.add(username);

		editField.add(cancel);
		editField.add(connect);
		connect.addActionListener(this);
		cancel.addActionListener(this);

		editField.setBorder(BorderFactory.createTitledBorder(wrap.getLang().getValue("login")));

		mainPanel.setBackground(Color.GREEN);
		mainPanel.add(editField, BorderLayout.CENTER);
		getSettings();

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			try {
				wrap.getConnector().openSocket(host.getText(), Integer.parseInt(port.getText()),
						username.getText());
				function.saveSettings(host.getText(), port.getText(), username.getText());
				dispose();
			} catch (NumberFormatException e2) {
				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("wrongPortError"));
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
