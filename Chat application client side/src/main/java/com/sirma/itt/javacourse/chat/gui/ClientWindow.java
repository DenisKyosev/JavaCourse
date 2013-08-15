package com.sirma.itt.javacourse.chat.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;

import com.sirma.itt.javacourse.chat.clientfunctions.ClientFunctions;
import com.sirma.itt.javacourse.chat.controllers.Wrapper;

public class ClientWindow extends JFrame implements ActionListener, Runnable {
	JTextArea outputArea = new JTextArea();
	JTextField inputField = new JTextField();
	JMenu connectMenu = new JMenu();
	JMenuItem connect = new JMenuItem();
	JMenuItem disconnect = new JMenuItem();
	JMenuItem bulgarian = new JMenuItem();
	JMenuItem english = new JMenuItem();
	JButton send = new JButton();
	JList userslList;
	JMenu langMenu = new JMenu();
	DefaultListModel<String> users = new DefaultListModel<>();
	Wrapper wrap = new Wrapper();

	ClientWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 800, 550);
		Container container = getContentPane();

		JPanel panel = new JPanel();
		container.add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JMenuBar menu = new JMenuBar();
		langMenu.add(bulgarian);
		langMenu.add(english);
		bulgarian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		english.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		langMenu.setMnemonic(KeyEvent.VK_L);
		connectMenu.setMnemonic(KeyEvent.VK_C);
		connectMenu.add(connect);
		connect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		disconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		disconnect.setEnabled(false);
		connectMenu.add(disconnect);
		menu.add(connectMenu);
		menu.add(langMenu);
		c.fill = GridBagConstraints.FIRST_LINE_START;
		c.ipadx = 160;
		c.ipady = 20;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(menu, c);
		connect.addActionListener(this);
		disconnect.addActionListener(this);
		bulgarian.addActionListener(this);
		english.addActionListener(this);

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
		wrap.getMsg().newComponent("Main area");
		outputArea.setFocusable(false);

		wrap.getMsg().newComponent("Users newUser");
		wrap.getMsg().newComponent("Users leftIser");
		userslList = new JList(users);
		userslList
				.setBorder(BorderFactory.createTitledBorder(wrap.getMsg().getText("onlineUsers")));
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 700;
		c.gridx = 4;
		c.gridy = 1;
		panel.add(userslList, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.gridwidth = 2;
		c.weighty = 0.01;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(inputField, c);
		inputField.addActionListener(this);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 1;
		c.gridwidth = 1;
		c.weighty = 0.01;
		c.gridx = 5;
		c.gridy = 2;
		panel.add(send, c);
		send.addActionListener(this);
		languageChanged();
		setVisible(true);

		new Thread(this).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			ClientLoginWindow login = new ClientLoginWindow(wrap);
		} else if (e.getSource() == disconnect) {
			try {
				ClientFunctions func = new ClientFunctions();
				wrap.getMessenger().sendCommand("disconnect", func.getSettings("lastUsedUsername"));
				wrap.getClient().close();
				wrap.setClient(null);

				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("disconnected"));
				users.removeAllElements();
				connect.setEnabled(true);
				disconnect.setEnabled(false);
			} catch (IOException e1) {
			}
		}
		if (e.getSource() == bulgarian) {
			wrap.getLang().setLanguage("bulgarian");
			languageChanged();
		}
		if (e.getSource() == english) {
			wrap.getLang().setLanguage("english");
			languageChanged();
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
			if (wrap.getMsg().hasUpdate("Main area")) {
				outputArea.append(wrap.getMsg().getUpdatedText("Main area"));
			}
			if (wrap.getMsg().hasUpdate("Users newUser")) {
				updateUsersList();
			}
			if (wrap.getMsg().hasUpdate("Users leftUser")) {
				users.removeElement(wrap.getMsg().getUpdatedText("Users newUser"));
			}
			if (wrap.getClient() != null) {
				disconnect.setEnabled(true);
				connect.setEnabled(false);
			}
		}
	}

	private void updateUsersList() {
		String message = wrap.getMsg().getUpdatedText("Users newUser");
		if (message.contains(";")) {
			String[] usernames = message.split(";");
			for (int i = 0; i < usernames.length; i++) {
				wrap.getMsg().setTextToBeUpdated("Main area", usernames[i]);
				users.addElement(usernames[i]);
			}
		} else {
			users.addElement(message);
		}
	}

	private void languageChanged() {
		connectMenu.setText(wrap.getLang().getValue("connectMenu"));
		connect.setText(wrap.getLang().getValue("connect"));
		disconnect.setText(wrap.getLang().getValue("disconnect"));
		bulgarian.setText(wrap.getLang().getValue("bulgarian"));
		english.setText(wrap.getLang().getValue("english"));
		send.setText(wrap.getLang().getValue("send"));
		userslList.setBorder(BorderFactory.createTitledBorder(wrap.getLang()
				.getValue("onlineUsers")));
		langMenu.setText(wrap.getLang().getValue("language"));
	}

}
