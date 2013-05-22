package com.sirma.itt.javacourse.reflections.task2;

// TODO: Auto-generated Javadoc
/**
 * instance by name.
 */
public class InstanceClassByName {

	/** The my class. */
	private Class<?> myClass;

	/**
	 * Instance by name.
	 * 
	 * @param name
	 *            the name
	 */
	public void instanceClassByName(String name) {
		try {
			myClass = Class.forName(name);
			myClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		@SuppressWarnings("rawtypes")
		Class[] interfaces = myClass.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println(interfaces[i].getName());
		}

		System.out.println(myClass.getSuperclass());
	}
}
