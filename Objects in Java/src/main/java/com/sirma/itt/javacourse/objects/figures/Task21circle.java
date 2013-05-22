package com.sirma.itt.javacourse.objects.figures;

// TODO: Auto-generated Javadoc
/**
 * The Class Task2circle.
 * 
 * @author Fester
 */
public class Task21circle extends Task21ellipse {

	/** The center. */
	private Task21point center;

	/** The radius. */
	private int radius;

	/**
	 * Circle.
	 * 
	 * @param center
	 *            set center
	 * @param radius
	 *            set radius
	 */
	public void circle(Task21point center, int radius) {
		this.setCenter(center);
		this.setRadius(radius);
	}

	/**
	 * Getter method for center.
	 * 
	 * @return the center
	 */
	@Override
	public Task21point getCenter() {
		return center;
	}

	/**
	 * Setter method for center.
	 * 
	 * @param center
	 *            the center to set
	 */
	@Override
	public void setCenter(Task21point center) {
		this.center = center;
	}

	/**
	 * Sets the radius.
	 * 
	 * @param radius
	 *            the new radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * Gets the radius.
	 * 
	 * @return the radius
	 */
	public int getRadius() {
		return this.radius;
	}
}
