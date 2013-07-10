package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Abstract objects mammals or aquatic animals.
 */
public class AbstractFactory {

	/**
	 * Gets the species factory.
	 * 
	 * @param type
	 *            the type
	 * @return the species factory
	 */
	SpeciesFactory getSpeciesFactory(String type) {
		if ("mammal".equals(type)) {
			return new MammalsFactory();
		} else {
			return new AquaticAnimalsFactory();
		}
	}

}
