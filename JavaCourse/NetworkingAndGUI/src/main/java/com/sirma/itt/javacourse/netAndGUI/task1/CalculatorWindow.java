package com.sirma.itt.javacourse.netAndGUI.task1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalculatorWindow extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	JTextField field;
	int operation;
	int type;
	double y;
	double x;
	CalculatorFunctions function = new CalculatorFunctions();
	JButton[] buttons;

	CalculatorWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 200, 400, 300);
		Container mainPanel = getContentPane();

		JPanel inputField = new JPanel(new BorderLayout(30, 30));
		field = new JTextField();

		inputField.setBorder(new EmptyBorder(10, 10, 10, 10));

		field.setFocusable(false);

		inputField.add(field);
		mainPanel.add(inputField, BorderLayout.PAGE_START);

		JPanel control = new JPanel(new GridLayout(0, 5, 10, 10));
		control.setBorder(new EmptyBorder(10, 10, 10, 10));

		buttons = new JButton[18];
		String[] buttonLabels = { "1", "2", "3", "+", "-", "4", "5", "6", "*", "/", "7", "8", "9",
				"C", "CC", "0", ".", "=" };

		for (int i = 0; i < buttonLabels.length; i++) {
			buttons[i] = new JButton(buttonLabels[i]);
			control.add(buttons[i]);
		}

		mainPanel.add(control);
		setVisible(true);
	}
}
