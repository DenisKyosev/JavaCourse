package com.sirma.itt.javacourse.designpatterns.singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class RunSingleton.
 */
public final class RunSingleton {

	/**
	 * Instantiates a new run singleton.
	 */
	private RunSingleton() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Singleton singleton = new Singleton();
		System.out.println(singleton.getInstance());
		System.out.println(singleton.getInstance());
		System.out.println(singleton.getInstance());
	}
}
