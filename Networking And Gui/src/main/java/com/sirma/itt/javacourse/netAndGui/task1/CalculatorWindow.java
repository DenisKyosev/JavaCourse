package com.sirma.itt.javacourse.netAndGui.task1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CalculatorWindow extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel inputField;

	protected JPanel getInputField() {
		return inputField;
	}

	protected JPanel getControl() {
		return control;
	}

	private final JPanel control;

	CalculatorWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		Container mainPanel = getContentPane();

		inputField = new JPanel(new BorderLayout(30, 30));

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainPanel.add(inputField, BorderLayout.PAGE_START);

		control = new JPanel(new GridLayout(0, 5, 10, 10));
		control.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainPanel.add(control);
		setVisible(true);
	}
}
