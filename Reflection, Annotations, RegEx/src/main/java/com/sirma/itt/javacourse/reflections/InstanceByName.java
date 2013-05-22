package com.sirma.itt.javacourse.reflections;

// TODO: Auto-generated Javadoc
/**
 * instance by name.
 */
public class InstanceByName {

	/** The my class. */
	private Class<?> myClass;

	/**
	 * Instance by name.
	 * 
	 * @param name
	 *            the name
	 */
	public void instanceByName(String name) {
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
