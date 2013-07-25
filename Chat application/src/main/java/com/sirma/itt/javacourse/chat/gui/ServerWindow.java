package com.sirma.itt.javacourse.chat.gui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ServerWindow extends JFrame {
	ServerWindow() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 250);
		Container mainPanel = getContentPane();

		JPanel outputField = new JPanel(new GridLayout(3, 3));

		outputField.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(outputField);

		JButton hello = new JButton("CICI");
		outputField.add(hello);

		ServerInterfaceComponents cmp = new ServerInterfaceComponents();
		outputField.add(cmp.users());
		setVisible(true);
	}
}
