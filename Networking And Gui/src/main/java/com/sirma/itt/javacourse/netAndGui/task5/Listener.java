package com.sirma.itt.javacourse.netAndGui.task5;

import javax.swing.JTextArea;

public class Listener implements Runnable {

	Listener(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

	private final JTextArea txtArea;
	private boolean updated = false;
	private String newResult = "";

	protected boolean isUpdated() {
		return updated;
	}

	protected void update(String result) {
		this.updated = true;
		this.newResult = result;
	}

	@Override
	public void run() {
		while (true) {
			if (isUpdated()) {

			}
		}
	}
}
