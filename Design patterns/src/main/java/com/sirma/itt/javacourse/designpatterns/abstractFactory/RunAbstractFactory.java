package com.sirma.itt.javacourse.designpatterns.abstractFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating RunAbstract objects.
 */
public final class RunAbstractFactory {

	/**
	 * Instantiates a new run abstract factory.
	 */
	private RunAbstractFactory() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		AbstractFactory abstractFactory = new AbstractFactory();

		SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory("mammal");
		Animal a1 = speciesFactory1.getAnimal("cat");
		System.out.println("a1 sound: ");
		a1.showPicture();

		Animal a2 = speciesFactory1.getAnimal("cow");
		System.out.println("a2 sound: ");
		a2.showPicture();

		SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory("aquatic");
		Animal a3 = speciesFactory2.getAnimal("fish");

		System.out.println("a3 sound: ");
		a3.showPicture();
		Animal a4 = speciesFactory2.getAnimal("seaturtle");

		System.out.println("a4 sound: ");
		a4.showPicture();
	}
}
