package com.sirma.itt.javacourse.objects.homogeneous;

/**
 * run method for binary homogeneous tree.
 * 
 * @author Fester
 */
public final class RunHomogeneousTree {
	private static HomogeneousTree tree = new HomogeneousTree(12);

	/**
	 * constructor.
	 */
	private RunHomogeneousTree() {

	}

	/**
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {

		tree.addNode(11);
		tree.addNode(2);
		tree.addNode(65);
		tree.addNode(32);
		tree.printTree();
		System.out.print(tree.search(11));
	}
}
