package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.homogeneous.HomogeneousTree;

/**
 * Testing class for sumator.
 * 
 * @author Fester
 */
public class TestHomogeneousTree {
	private HomogeneousTree tree = new HomogeneousTree(22);

	/**
	 * testing int sumator method.
	 */
	@Test
	public void testInts() {
		int[] arr = { 2, 33, 4, 65, 23, 2 };
		int[] arr2 = { 2, 22, 33, 4, 65, 23, 2 };
		String res;
		Arrays.sort(arr2);

		for (int i = 0; i < arr.length; i++) {
			tree.addNode(arr[i]);
		}

		res = Arrays.toString(arr2);

		res = res.replace("[", "");
		res = res.replace("]", " ");
		res = res.replace(", ", " ");
		assertEquals(res, tree.generateTreeString());
	}
}