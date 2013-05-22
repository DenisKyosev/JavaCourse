package com.sirma.itt.javacourse.reflections;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomModificatorsClass.
 */
public class RandomModificatorsClass {

	/** The public int. */
	public int publicInt = 1;

	/** The private float. */
	@SuppressWarnings("unused")
	private float privateFloat;

	/** The protected string. */
	protected String protectedString = "test string";

	/**
	 * Public bool.
	 * 
	 * @return true, if successful
	 */
	public boolean publicBool() {
		return false;

	}

	/**
	 * Private double.
	 * 
	 * @return the double
	 */
	@SuppressWarnings("unused")
	private double privateDouble() {
		return 1.1;

	}
}
