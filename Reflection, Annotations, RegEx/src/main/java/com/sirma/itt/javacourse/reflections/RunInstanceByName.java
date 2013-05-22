package com.sirma.itt.javacourse.reflections;

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
		InstanceByName inst = new InstanceByName();
		inst.instanceByName("com.sirma.itt.javacourse.reflections.ChildClass");
	}

}
