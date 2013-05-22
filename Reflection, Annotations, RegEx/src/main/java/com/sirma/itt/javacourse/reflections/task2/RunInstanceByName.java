package com.sirma.itt.javacourse.reflections.task2;

/**
 * run class for InstanceByName.
 */
public final class RunInstanceByName {

	/**
	 * constructor.
	 */
	private RunInstanceByName() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		InstanceClassByName inst = new InstanceClassByName();
		inst.instanceClassByName("com.sirma.itt.javacourse.reflections.task2.ChildClass");
	}

}
