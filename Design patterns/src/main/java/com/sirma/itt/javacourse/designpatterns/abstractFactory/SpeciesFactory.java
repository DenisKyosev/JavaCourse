package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating animal Species objects.
 */
public interface SpeciesFactory {

	/**
	 * Gets the animal.
	 * 
	 * @param type
	 *            the type
	 * @return the animal
	 */
	Animal getAnimal(String type);
}
