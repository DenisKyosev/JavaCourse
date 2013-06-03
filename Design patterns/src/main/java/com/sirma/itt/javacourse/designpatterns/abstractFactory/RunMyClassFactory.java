package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Age objects.
 */
public class RunMyClassFactory {

	/**
	 * Instantiates a new run my class factory.
	 */
	protected RunMyClassFactory() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		MyClassFactory fac = new MyClassFactory();
		System.out.println(fac.age("555"));
	}

}
