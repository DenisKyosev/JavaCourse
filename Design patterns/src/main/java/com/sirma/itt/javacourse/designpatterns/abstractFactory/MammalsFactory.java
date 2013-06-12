package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Mammals objects.
 */
public class MammalsFactory implements SpeciesFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Animal getAnimal(String type) {
		if ("cow".equals(type)) {
			return new Cow();
		} else {
			return new Cat();
		}
	}

}
