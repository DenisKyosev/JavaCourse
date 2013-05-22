package com.sirma.itt.javacourse.objects.figures;

/**
 * Ellipse class.
 * 
 * @author Fester
 */
public class Task21ellipse extends Figure {

	/** The center. */
	private Task21point center;
	private int width;
	private int height;

	/**
	 * Gets the width.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 * 
	 * @param width
	 *            width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 * 
	 * @param height
	 *            height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the center.
	 * 
	 * @param center
	 *            the new center
	 */
	public void setCenter(Task21point center) {
		this.center = center;
	}

	/**
	 * Gets the center.
	 * 
	 * @return the center
	 */
	public Task21point getCenter() {
		return this.center;
	}

}
