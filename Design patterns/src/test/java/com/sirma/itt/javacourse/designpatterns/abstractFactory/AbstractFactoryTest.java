package com.sirma.itt.javacourse.designpatterns.abstractFactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractFactoryTest.
 */
public class AbstractFactoryTest {

	/**
	 * Abstract factory test.
	 */
	@Test
	public void abstractFactoryTest() {
		AbstractFactory abstractFactory = new AbstractFactory();

		SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory("mammal");

		Animal a1 = speciesFactory1.getAnimal("cat");
		assertEquals("it's a cat", a1.showPicture());

		a1 = speciesFactory1.getAnimal("cow");
		assertEquals("it's a cow", a1.showPicture());

		a1 = speciesFactory1.getAnimal("asd");
		assertEquals("it's a cat", a1.showPicture());

		speciesFactory1 = abstractFactory.getSpeciesFactory("aquatic");

		a1 = speciesFactory1.getAnimal("wdawda");
		assertEquals("it's a sea turtle", a1.showPicture());

		a1 = speciesFactory1.getAnimal("fish");
		assertEquals("it's a fish", a1.showPicture());
	}

	/**
	 * Test by reflection.
	 */
	@Test
	public void byReflection() {
		AbstractFactory factory = new AbstractFactory();
		assertEquals("AquaticAnimalsFactory", factory.getSpeciesFactory("aquatic").getClass()
				.getSimpleName());

		assertEquals("Fish", factory.getSpeciesFactory("aquatic").getAnimal("fish").getClass()
				.getSimpleName());
		assertEquals("SeaTurtle", factory.getSpeciesFactory("aquatic").getAnimal("wadd").getClass()
				.getSimpleName());
	}
}
