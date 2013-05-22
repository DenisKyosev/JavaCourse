package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Class RunPageBean.
 */
public final class RunPageBean {

	/**
	 * Instantiates a new run page bean.
	 */
	private RunPageBean() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
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
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		Scanner sc = new Scanner(System.in);
		String scan = sc.next();
		while (!"close".equals(scan)) {
			if ("next".equals(scan)) {
				list2 = paging.next();
				for (int i = 0; i < list2.size(); i++) {
					System.out.println(list2.get(i));
				}
			} else if ("previous".equals(scan)) {
				list2 = paging.previous();
				for (int i = 0; i < list2.size(); i++) {
					System.out.println(list2.get(i));
				}
			}
			scan = sc.next();
		}
		sc.close();
	}
}
