package com.sirma.itt.javacourse.chat.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import com.sirma.itt.javacourse.chat.controllers.Wrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Client Window.
 */
public class ClientWindow extends JFrame implements ActionListener, KeyListener, Runnable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -569662617699323268L;

	/** The output area. */
	private final JTextArea outputArea = new JTextArea();

	/** The input field. */
	private final JTextField inputField = new JTextField();

	/** The connect menu. */
	private final JMenu connectMenu = new JMenu();

	/** The connect menu item. */
	private final JMenuItem connect = new JMenuItem();

	/** The disconnect menu item. */
	private final JMenuItem disconnect = new JMenuItem();

	/** The bulgarian menu item. */
	private final JMenuItem bulgarian = new JMenuItem();

	/** The english menu item. */
	private final JMenuItem english = new JMenuItem();

	/** The send button. */
	private final JButton send = new JButton();

	/** The users list. */
	private final JList<String> usersList;

	/** The language menu. */
	private final JMenu langMenu = new JMenu();

	/** The users list. */
	private final DefaultListModel<String> users = new DefaultListModel<String>();

	/** The wrapper. */
	private final Wrapper wrap = new Wrapper();

	/**
	 * Instantiates a new client window.
	 */
	ClientWindow() {
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
		connect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
		disconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
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

		wrap.getMsg().newComponent("newUser");
		wrap.getMsg().newComponent("userLeft");

		usersList = new JList<String>(users);
		JScrollPane scrollList = new JScrollPane(usersList);
		usersList.setBorder(BorderFactory
				.createTitledBorder(wrap.getLang().getValue("onlineUsers")));
		c.fill = GridBagConstraints.VERTICAL;
		c.ipadx = 700;
		c.gridx = 4;
		c.gridy = 1;
		panel.add(scrollList, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 5;
		c.gridwidth = 2;
		c.weighty = 0.01;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(inputField, c);
		inputField.addActionListener(this);
		inputField.addKeyListener(this);
		inputField.setText("Connect first");
		inputField.setEnabled(false);

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
		this.addWindowListener(exitListener);

		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connect) {
			new ClientLoginWindow(wrap);
		} else if (e.getSource() == disconnect) {
			try {
				wrap.getClient().close();
				wrap.setClient(null);

				wrap.getMsg().setTextToBeUpdated("Main area",
						wrap.getLang().getValue("disconnected"));
				users.removeAllElements();
				enableConnect();
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

		if (e.getSource() == send) {
			wrap.getMessenger().send(inputField.getText());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			if (wrap.getMsg().hasUpdate("Main area")) {
				String message = wrap.getMsg().getUpdatedText("Main area");
				outputArea.append(message);
				wrap.getLog().log(message);
			}

			if (wrap.getMsg().hasUpdate("newUser")) {
				String usersList = wrap.getMsg().getUpdatedText("newUser");
				if (usersList.contains("::")) {
					String[] usernames = usersList.split("::");
					for (int i = 0; i < usernames.length; i++) {
						users.addElement(usernames[i].trim());
					}
				} else {
					users.addElement(usersList.trim());
				}
			}

			if (wrap.getMsg().hasUpdate("userLeft")) {
				users.removeElement(wrap.getMsg().getUpdatedText("userLeft").trim());
			}

			if (wrap.getClient() != null) {
				disableConnect();
			}
		}
	}

	/**
	 * Enable connect button. Disable disconnect button.
	 */
	private void enableConnect() {
		disconnect.setEnabled(false);
		connect.setEnabled(true);
		inputField.setEnabled(false);
		inputField.setText("Connect first");
	}

	/**
	 * Disable connect button. Enable disconnect button.
	 */
	private void disableConnect() {
		if (!inputField.isEnabled()) {
			disconnect.setEnabled(true);
			connect.setEnabled(false);
			inputField.setEnabled(true);
			inputField.setText("");
		}
	}

	/** The exit listener. */
	private final WindowListener exitListener = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			if (wrap.getClient() != null) {
				try {
					wrap.getClient().close();
					wrap.setClient(null);
				} catch (IOException e1) {
				}
			}
			System.exit(0);
		}
	};

	/**
	 * Updates GUI on language change.
	 */
	private void languageChanged() {
		connectMenu.setText(wrap.getLang().getValue("connectMenu"));
		connect.setText(wrap.getLang().getValue("connect"));
		disconnect.setText(wrap.getLang().getValue("disconnect"));
		bulgarian.setText(wrap.getLang().getValue("bulgarian"));
		english.setText(wrap.getLang().getValue("english"));
		send.setText(wrap.getLang().getValue("send"));
		usersList.setBorder(BorderFactory
				.createTitledBorder(wrap.getLang().getValue("onlineUsers")));
		langMenu.setText(wrap.getLang().getValue("language"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			wrap.getMessenger().send(inputField.getText());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

}
