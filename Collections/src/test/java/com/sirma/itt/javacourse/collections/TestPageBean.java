package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * The Class TestPageBean.
 */
public class TestPageBean {

	/**
	 * Test pagebean.
	 */
	@Test
	public void testPageBean() {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		list.add("4");
		list.add("5");
		list.add("6");

		list.add("7");
		list.add("8");
		list.add("9");

		list.add("10");
		list.add("11");
		list.add("12");

		list.add("13");
		list.add("14");

		PageBean<String> paging = new PageBean<>(list, 3);

		List<String> list2 = paging.next();
		assertEquals("[1, 2, 3]", list2.toString());

		list2 = paging.next();
		assertEquals("[4, 5, 6]", list2.toString());

		list2 = paging.previous();
		assertEquals("[1, 2, 3]", list2.toString());

		list2 = paging.lastPage();
		assertEquals("[13, 14]", list2.toString());

		list2 = paging.firstPage();
		assertEquals("[1, 2, 3]", list2.toString());

		assertEquals(true, paging.hasNext());
		assertEquals(false, paging.hasPrevious());

		paging.next();
		assertEquals(true, paging.hasPrevious());
		assertEquals(2, paging.getCurrentPageNumber());
	}
}
