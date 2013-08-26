package com.sirma.itt.javacourse.chat.controllers;

public interface Command {
	void execute(String command, String property);
}
