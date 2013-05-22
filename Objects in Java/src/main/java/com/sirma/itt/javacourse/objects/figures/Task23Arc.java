package com.sirma.itt.javacourse.objects.figures;

/**
 * arc class.
 * 
 * @author Fester
 */
public class Task23Arc extends Task23PolyLine {
	private Task23Line[] lines;

	/**
	 * Getter method for lines.
	 * 
	 * @return the lines
	 */
	public Task23Line[] getLines() {
		return lines;
	}

	/**
	 * Setter method for lines.
	 * 
	 * @param lines
	 *            the lines to set
	 */
	public void setLines(Task23Line[] lines) {
		this.lines = lines;
	}
}
