package com.sirma.itt.javacourse.netAndGUI.task1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners extends CalculatorWindow implements ActionListener {
	Listeners() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (function.isNumber(cmd)) {
			field.setText(field.getText() + cmd);
			y = Double.parseDouble(field.getText());
		}
		if (!field.getText().isEmpty()) {
			if ("+".equals(cmd)) {
				x = Double.parseDouble(field.getText());
				field.setText("");
				operation = 1;
			} else if ("-".equals(cmd)) {
				x = Double.parseDouble(field.getText());
				field.setText("");
				operation = 2;
			} else if ("*".equals(cmd)) {
				x = Double.parseDouble(field.getText());
				field.setText("");
				operation = 3;
			} else if ("/".equals(cmd)) {
				x = Double.parseDouble(field.getText());
				field.setText("");
				operation = 4;
			} else if (".".equals(cmd)) {
				field.setText(function.putDot(field.getText()));
			} else if ("C".equals(cmd)) {
				field.setText(function.deleteDigit(field.getText()));
			} else if ("CC".equals(cmd)) {
				x = 0;
				y = 0;
				field.setText("");
			} else if ("=".equals(cmd)) {
				field.setText(function.equal(operation, x, y));
				x = Double.parseDouble(field.getText());
			}
		}
	}

}
