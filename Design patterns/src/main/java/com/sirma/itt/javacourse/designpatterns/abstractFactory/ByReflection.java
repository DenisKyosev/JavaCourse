package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ByReflection.
 */
public class ByReflection implements SpeciesFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Animal getAnimal(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates instance.
	 * 
	 * @param className
	 *            the class name
	 * @return the object
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public Object createInstance(String className) throws ClassNotFoundException {

		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;

	}
}
