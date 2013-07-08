package com.sirma.itt.javacourse.netAndGui.task5;

public class Originator {

	public Memento saveToMemento(String save) {
		return new Memento(save);
	}

	public String restoreFromMemento(Memento memento) {
		return memento.getSavedState();
	}

}
