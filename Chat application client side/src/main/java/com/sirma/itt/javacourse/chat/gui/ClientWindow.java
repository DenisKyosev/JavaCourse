package com.sirma.itt.javacourse.chat.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import com.sirma.itt.javacourse.chat.controllers.InterfaceUpdater;

public class ClientWindow extends JFrame implements ActionListener, Runnable {
	JTextArea outputArea;
	JTextField inputField;
	JMenuItem connect;
	JMenuItem bulgarian;
	JMenuItem english;
	JButton send;
	JList userslList;
	JMenu langMenu;

	InterfaceUpdater msg = new InterfaceUpdater();
	Socket client;

	ClientWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 550);
		Container container = getContentPane();

		JPanel panel = new JPanel();
		container.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JMenuBar menu = new JMenuBar();
		langMenu = new JMenu(msg.getText("language"));
		connect = new JMenuItem(msg.getText("connect"));
		bulgarian = new JMenuItem(msg.getText("bulgarian"));
		english = new JMenuItem(msg.getText("english"));
		langMenu.add(bulgarian);
		langMenu.add(english);
		menu.add(connect);
		menu.add(langMenu);
		c.fill = GridBagConstraints.FIRST_LINE_START;
		c.ipadx = 160;
		c.ipady = 20;
		c.gridx = 0;
		c.gridy = 0;
		connect.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		langMenu.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		panel.add(menu, c);
		connect.addActionListener(this);
		bulgarian.addActionListener(this);
		english.addActionListener(this);

		outputArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(outputArea);
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 1200;
		c.gridwidth = 4;
		c.weightx = 0.7;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		DefaultCaret caret = (DefaultCaret) outputArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		panel.add(scroll, c);
		outputArea.setFocusable(false);

		String[] users = { "1", "2" };
		userslList = new JList(users);
		userslList.setBorder(BorderFactory.createTitledBorder(msg.getText("onlineUsers")));
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 700;
		c.gridx = 4;

		c.gridy = 1;
		panel.add(userslList, c);

		inputField = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.gridwidth = 2;
		c.weighty = 0.01;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(inputField, c);
		inputField.addActionListener(this);

		send = new JButton(msg.getText("send"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 1;
		c.gridwidth = 1;
		c.weighty = 0.01;
		c.gridx = 5;
		c.gridy = 2;
		panel.add(send, c);
		send.addActionListener(this);

		setVisible(true);

		new Thread(this).start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			ClientLoginWindow login = new ClientLoginWindow(msg, client);
		}
		if (e.getSource() == bulgarian) {
			msg.setLang("bulgarian");
			updateUI();
		}
		if (e.getSource() == english) {
			msg.setLang("english");
			updateUI();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (msg.hasUpdate("Main area")) {
				outputArea.append(msg.getUpdatedText("Main area"));
			}
		}
	}

	private void updateUI() {
		connect.setText(msg.getText("connect"));
		bulgarian.setText(msg.getText("bulgarian"));
		english.setText(msg.getText("english"));
		send.setText(msg.getText("send"));
		userslList.setBorder(BorderFactory.createTitledBorder(msg.getText("onlineUsers")));
		langMenu.setText(msg.getText("language"));
	}
}
