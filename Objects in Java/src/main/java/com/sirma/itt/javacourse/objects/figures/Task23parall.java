package com.sirma.itt.javacourse.objects.figures;

/**
 * parallelogram.
 * 
 * @author Fester
 */
public class Task23parall extends Task23PolyLine {
	private int angle;
	private Task23Line width;
	private Task23Line height;

	/**
	 * Getter method for angle.
	 * 
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Setter method for angle.
	 * 
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * Getter method for width.
	 * 
	 * @return the width
	 */
	public Task23Line getWidth() {
		return width;
	}

	/**
	 * Setter method for width.
	 * 
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Task23Line width) {
		this.width = width;
	}

	/**
	 * Getter method for height.
	 * 
	 * @return the height
	 */
	public Task23Line getHeight() {
		return height;
	}

	/**
	 * Setter method for height.
	 * 
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Task23Line height) {
		this.height = height;
	}

}
