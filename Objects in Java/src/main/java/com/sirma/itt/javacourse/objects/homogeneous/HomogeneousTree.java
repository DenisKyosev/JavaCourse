package com.sirma.itt.javacourse.objects.homogeneous;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * binary tree.
 * 
 * @author Fester
 */
public class HomogeneousTree {

	private HomogeneousNode root;
	private String print = "";

	/**
	 * constructor.
	 * 
	 * @param data
	 *            the root
	 */
	public HomogeneousTree(int data) {

		this.root = new HomogeneousNode(data);
	}

	/**
	 * overloading for node adding method.
	 * 
	 * @param data
	 *            root
	 */
	public void addNode(int data) {
		addNode(data, root);
	}

	/**
	 * add node method.
	 * 
	 * @param data
	 *            value to be added
	 * @param node
	 *            root
	 */
	private void addNode(int data, HomogeneousNode node) {
		HomogeneousNode current = node;
		if (current == null) {
			current = root;
		}

		if (data > current.getValue()) {
			if (current.getRight() == null) {
				current.setRight(new HomogeneousNode(data));
			} else {
				addNode(data, current.getRight());
			}
		} else {
			if (current.getLeft() == null) {
				current.setLeft(new HomogeneousNode(data));
			} else {
				addNode(data, current.getLeft());
			}
		}
	}

	/**
	 * overloading for search method.
	 * 
	 * @param data
	 *            value to be found
	 * @return true/false
	 */
	boolean search(int data) {
		return search(data, root);
	}

	/**
	 * search method.
	 * 
	 * @param data
	 *            value to be found
	 * @param node
	 *            root
	 * @return true/false
	 */
	public boolean search(int data, HomogeneousNode node) {
		HomogeneousNode current;
		if (node == null) {
			current = root;
		}
		current = node;
		if (data > current.getValue()) {
			if (current.getRight() != null) {
				return search(data, current.getRight());
			}
		} else if (data < current.getValue()) {
			if (current.getLeft() != null) {
				return search(data, current.getLeft());
			}
		} else {
			return true;
		}
		return false;
	}

	/**
	 * overloading for generating method.
	 * 
	 * @return override
	 */
	public String generateTreeString() {
		return generateTreeString(root);
	}

	/**
	 * generating method.
	 * 
	 * @param node
	 *            root
	 * @return all nodes sorted lrr
	 */
	public String generateTreeString(HomogeneousNode node) {
		if (node.getLeft() != null) {
			generateTreeString(node.getLeft());
		}
		print += node.getValue();
		print += " ";
		if (node.getRight() != null) {
			generateTreeString(node.getRight());
		}

		return print;
	}

	/**
	 * print method.
	 */
	public void printTree() {
		Logger log = Logger.getLogger("com.sirma.itt");
		log.log(Level.INFO, generateTreeString());
	}

	/**
	 * Getter method for root.
	 * 
	 * @return the root
	 */
	public HomogeneousNode getRoot() {
		return root;
	}

	/**
	 * Setter method for root.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(HomogeneousNode root) {
		this.root = root;
	}

}
