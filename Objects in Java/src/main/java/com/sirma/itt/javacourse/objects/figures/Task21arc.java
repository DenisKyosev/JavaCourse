package com.sirma.itt.javacourse.objects.figures;


/**
 * class for arc.
 * 
 * @author Fester
 */
public class Task21arc extends Task21ellipse {
	private Task21point p1;
	private Task21point p2;
	private int angle;

	/**
	 * set new arc.
	 * 
	 * @param p1
	 *            start point
	 * @param p2
	 *            end point
	 * @param angle
	 *            angle
	 */
	public void arc(Task21point p1, Task21point p2, int angle) {
		this.setP1(p1);
		this.setP2(p2);
		this.setAngle(angle);
	}

	/**
	 * Getter method for p1.
	 * 
	 * @return the p1
	 */
	public Task21point getP1() {
		return p1;
	}

	/**
	 * Setter method for p1.
	 * 
	 * @param p1
	 *            the p1 to set
	 */
	public void setP1(Task21point p1) {
		this.p1 = p1;
	}

	/**
	 * Getter method for p2.
	 * 
	 * @return the p2
	 */
	public Task21point getP2() {
		return p2;
	}

	/**
	 * Setter method for p2.
	 * 
	 * @param p2
	 *            the p2 to set
	 */
	public void setP2(Task21point p2) {
		this.p2 = p2;
	}

	/**
	 * set angle.
	 * 
	 * @param angle
	 *            angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * get angle.
	 * 
	 * @return angle
	 */
	public int getAngle() {
		return angle;
	}
}
