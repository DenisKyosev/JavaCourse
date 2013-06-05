package com.sirma.itt.javacourse.designpatterns.observer;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
public class Product {

	/** The id of the product. */
	private int id;

	/** The name of the product. */
	private String name;

	/**
	 * Instantiates a new product.
	 * 
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 */
	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
