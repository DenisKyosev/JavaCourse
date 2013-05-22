package com.sirma.itt.javacourse.objects.homogeneous;

import java.util.ArrayList;

/**
 * node of a tree.
 * 
 * @param <T>
 * @author Fester
 */
public class Node<T> {
	private T data;
	private Node<T> parent;
	private ArrayList<Node<T>> children;

	/**
	 * method for adding a child.
	 * 
	 * @param child
	 *            child node
	 */
	void addChild(Node<T> child) {
		if (child.getParent() != null) {
			throw new IllegalArgumentException();
		}
		children.add(child);
		child.setParent(this);
	}

	/**
	 * Getter method for data.
	 * 
	 * @return the data
	 */
	@SuppressWarnings("unused")
	private T getData() {
		return data;
	}

	/**
	 * Setter method for data.
	 * 
	 * @param data
	 *            the data to set
	 */
	@SuppressWarnings("unused")
	private void setData(T data) {
		this.data = data;
	}

	/**
	 * Getter method for parent.
	 * 
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * Setter method for parent.
	 * 
	 * @param parent
	 *            the parent to set
	 */
	private void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * Getter method for children.
	 * 
	 * @return the children
	 */
	public ArrayList<Node<T>> getChildren() {
		return children;
	}

	/**
	 * Setter method for children.
	 * 
	 * @param children
	 *            the children to set
	 */
	@SuppressWarnings("unused")
	private void setChildren(ArrayList<Node<T>> children) {
		this.children = children;
	}
}
