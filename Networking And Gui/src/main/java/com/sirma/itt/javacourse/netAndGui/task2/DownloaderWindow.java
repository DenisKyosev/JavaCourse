package com.sirma.itt.javacourse.netAndGui.task2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class DownloaderWindow extends JFrame {
	JProgressBar progress;
	JTextField source;
	JTextField destination;
	JTextField errorField;
	JButton download;
	Container mainPanel;

	DownloaderWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		mainPanel = getContentPane();

		mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

		source = new JTextField("Enter source");
		destination = new JTextField("Enter destination");

		mainPanel.add(source, BorderLayout.PAGE_START);
		mainPanel.add(destination, BorderLayout.LINE_END);

		download = new JButton("Download");

		mainPanel.add(download, BorderLayout.CENTER);
		errorField = new JTextField();
		errorField.setFocusable(false);
		errorField.setBackground(Color.GREEN);

		mainPanel.add(errorField, BorderLayout.LINE_END);

		setVisible(true);
	}
}
