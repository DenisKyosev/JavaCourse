package com.sirma.itt.javacourse.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// TODO: Auto-generated Javadoc
/**
 * run class for private class.
 */
public final class RunPrivateClass {
	/**
	 * constr.
	 */
	private RunPrivateClass() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		
		
		PrivateClass prv = new PrivateClass();
		Class<?> prvInfo = prv.getClass();

		Field[] prvField = prvInfo.getDeclaredFields();

		for (int i = 0; i < prvField.length; i++) {
			prvField[i].setAccessible(true);
			try {
				System.out.println(prvField[i].get(prv));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		Method[] prvMethod = prvInfo.getDeclaredMethods();
		for (int i = 0; i < prvMethod.length; i++) {
			prvMethod[i].setAccessible(true);

			try {
				System.out.println(prvMethod[i].invoke(prv));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
	}

}
