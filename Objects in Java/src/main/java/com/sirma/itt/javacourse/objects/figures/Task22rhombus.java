package com.sirma.itt.javacourse.objects.figures;

/**
 * rhombus class.
 * 
 * @author Fester
 */
public class Task22rhombus extends Task22fourSide {
	private int width;
	private Task22square side;

	/**
	 * Getter method for width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Setter method for width.
	 * 
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Getter method for side.
	 * 
	 * @return the side
	 */
	public Task22square getSide() {
		return side;
	}

	/**
	 * Setter method for side.
	 * 
	 * @param side
	 *            the side to set
	 */
	public void setSide(Task22square side) {
		this.side = side;
	}

}
