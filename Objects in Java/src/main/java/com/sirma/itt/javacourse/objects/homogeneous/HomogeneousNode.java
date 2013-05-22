package com.sirma.itt.javacourse.objects.homogeneous;

/**
 * class for one node of a tree.
 * 
 * @author Fester
 */
public class HomogeneousNode {
	private int value;
	private HomogeneousNode left;
	private HomogeneousNode right;

	/**
	 * constructor.
	 * 
	 * @param data
	 *            node's value
	 */
	public HomogeneousNode(int data) {
		this.value = data;
	}

	/**
	 * Getter method for value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Setter method for value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Getter method for left.
	 * 
	 * @return the left
	 */
	public HomogeneousNode getLeft() {
		return left;
	}

	/**
	 * Setter method for left.
	 * 
	 * @param left
	 *            the left to set
	 */
	public void setLeft(HomogeneousNode left) {
		this.left = left;
	}

	/**
	 * Getter method for right.
	 * 
	 * @return the right
	 */
	public HomogeneousNode getRight() {
		return right;
	}

	/**
	 * Setter method for right.
	 * 
	 * @param right
	 *            the right to set
	 */
	public void setRight(HomogeneousNode right) {
		this.right = right;
	}
}
