package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Aquatic Animals objects.
 */
public class AquaticAnimalsFactory implements SpeciesFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Animal getAnimal(String type) {
		if ("fish".equals(type)) {
			return new Fish();
		} else {
			return new SeaTurtle();
		}
	}
}
