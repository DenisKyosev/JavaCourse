package com.sirma.itt.javacourse.objects.heterogeneous;

/**
 * binary tree.
 * 
 * @author Fester
 */
public class HeterogeneousTree {

	private HeterogeneousNode root;

	/**
	 * constructor.
	 * 
	 * @param data
	 *            the root
	 */
	public HeterogeneousTree(Number data) {

		this.root = new HeterogeneousNode(data);
	}

	/**
	 * overloading method for node adding method.
	 * 
	 * @param data
	 *            root
	 */
	void addNode(Number data) {
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
	public void addNode(Number data, HeterogeneousNode node) {
		HeterogeneousNode current = node;
		if (current == null) {
			current = root;
		}

		String currentStr = current.getValue().toString();
		String dataVal = data.toString();
		if (dataVal.compareTo(currentStr) > 0) {
			if (current.getRight() == null) {
				current.setRight(new HeterogeneousNode(data));
			} else {
				addNode(data, current.getRight());
			}
		} else {
			if (current.getLeft() == null) {
				current.setLeft(new HeterogeneousNode(data));
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
	boolean search(Number data) {
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
	public boolean search(Number data, HeterogeneousNode node) {
		HeterogeneousNode current;
		if (node == null) {
			current = root;
		}
		current = node;
		String currentStr = current.getValue().toString();
		String dataVal = data.toString();

		if (dataVal.compareTo(currentStr) > 0) {
			if (current.getRight() != null) {
				return search(data, current.getRight());
			}
		} else if (dataVal.compareTo(currentStr) < 0) {
			if (current.getLeft() != null) {
				return search(data, current.getLeft());
			}
		} else {
			return true;
		}
		return false;
	}

	/**
	 * overloading for print method.
	 */
	void printTree() {
		printTree(root);
	}

	/**
	 * print method.
	 * 
	 * @param node
	 *            root
	 */
	void printTree(HeterogeneousNode node) {
		if (node.getLeft() != null) {
			printTree(node.getLeft());
		}
		System.out.println(node.getValue());

		if (node.getRight() != null) {
			printTree(node.getRight());
		}

	}

	/**
	 * Getter method for root.
	 * 
	 * @return the root
	 */
	public HeterogeneousNode getRoot() {
		return root;
	}

	/**
	 * Setter method for root.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(HeterogeneousNode root) {
		this.root = root;
	}

}
