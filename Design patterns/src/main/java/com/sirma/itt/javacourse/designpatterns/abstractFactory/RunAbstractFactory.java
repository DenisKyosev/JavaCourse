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
		System.out.println("animal 1: " + a1.showPicture());

		Animal a2 = speciesFactory1.getAnimal("cow");
		System.out.println("animal 2: " + a2.showPicture());

		SpeciesFactory speciesFactory2 = abstractFactory.getSpeciesFactory("aquatic");
		Animal a3 = speciesFactory2.getAnimal("fish");
		System.out.println("animal 3: " + a3.showPicture());

		Animal a4 = speciesFactory2.getAnimal("seaturtle");
		System.out.println("animal 4: " + a4.showPicture());

		System.out.println(abstractFactory.getSpeciesFactory("aquatic").getClass().getSimpleName());

		System.out.println(abstractFactory.getSpeciesFactory("aquatic").getAnimal("fish")
				.getClass().getSimpleName());

		System.out.println(abstractFactory.getSpeciesFactory("aquatic").getAnimal("wadd")
				.getClass().getSimpleName());
	}
}
