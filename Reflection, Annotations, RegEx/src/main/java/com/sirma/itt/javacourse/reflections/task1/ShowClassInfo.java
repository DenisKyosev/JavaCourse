package com.sirma.itt.javacourse.reflections.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * showing info for other class.
 */
public final class ShowClassInfo {

	/**
	 * Instantiates a new show class info.
	 */
	private ShowClassInfo() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		RandomModificatorsClass randomClass = new RandomModificatorsClass();

		Field[] flds = randomClass.getClass().getDeclaredFields();
		System.out.println("VARIABLES: \n");
		for (int i = 0; i < flds.length; i++) {
			String name = flds[i].getName();
			flds[i].setAccessible(true);
			Class<?> type = flds[i].getType();
			int modifier = flds[i].getModifiers();

			System.out.print("Name:" + name + "\nType:" + type + "\nModifier: "
					+ Modifier.toString(modifier) + "\n\n");

		}

		Method[] method = randomClass.getClass().getDeclaredMethods();
		System.out.println("METHODS:\n");
		for (int i = 0; i < method.length; i++) {
			String name = method[i].getName();
			flds[i].setAccessible(true);
			Class<?> type = method[i].getReturnType();
			int modifier = method[i].getModifiers();

			System.out.print("Name:" + name + "\nType:" + type + "\nModifier: "
					+ Modifier.toString(modifier) + "\n\n");
		}

		@SuppressWarnings("rawtypes")
		Constructor[] constr = randomClass.getClass().getDeclaredConstructors();
		System.out.println("CONSTRUCTORS:\n");
		for (int i = 0; i < constr.length; i++) {
			String name = constr[i].getName();
			flds[i].setAccessible(true);

			int modifier = constr[i].getModifiers();

			System.out.print("Name:" + name + "\nType:" + "\nModifier: "
					+ Modifier.toString(modifier) + "\n\n");
		}
	}
}
