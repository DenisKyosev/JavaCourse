package com.sirma.itt.javacourse.threads.task5;

// TODO: Auto-generated Javadoc
/**
 * run class for ArrayWithExceptions.
 */
public final class RunArrayWithExceptions {
	/**
	 * constructor.
	 */
	private RunArrayWithExceptions() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 * @throws ArrayIsFullException
	 * @throws ArrayIsEmptyException
	 */
	public static void main(String[] args) {
		ArrayAdd addElement = new ArrayAdd();
		Thread add = new Thread(addElement);

		ArrayRemove removeElement = new ArrayRemove();
		Thread remove = new Thread(removeElement);

		add.start();
		remove.start();
	}
}
