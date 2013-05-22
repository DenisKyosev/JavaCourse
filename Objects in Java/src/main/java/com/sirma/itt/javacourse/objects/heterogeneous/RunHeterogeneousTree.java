package com.sirma.itt.javacourse.objects.heterogeneous;

/**
 * run method for binary homogeneous tree.
 * 
 * @author Fester
 */
public final class RunHeterogeneousTree {
	private static HeterogeneousTree tree = new HeterogeneousTree(12.9);

	/**
	 * constructor.
	 */
	private RunHeterogeneousTree() {

	}

	/**
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {

		tree.addNode(11);
		tree.addNode(22.2);
		tree.addNode(65.4f);
		tree.addNode(32);
		tree.printTree();
		System.out.print(tree.search(11));
	}
}
