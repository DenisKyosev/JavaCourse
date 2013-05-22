package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PageBean.
 * 
 * @param <E>
 *            the element type
 */
public final class PageBean<E> {

	/** The list. */
	private ArrayList<E> myList = new ArrayList<>();

	/** The page size. */
	private int pageSize;

	/** The current page. */
	private int currentPage = 0;

	/**
	 * Instantiates a new page bean.
	 * 
	 * @param myList
	 *            the list
	 * @param pageSize
	 *            the page size
	 */
	public PageBean(ArrayList<E> myList, int pageSize) {
		this.myList = myList;
		this.pageSize = pageSize;
	}

	/**
	 * Next page.
	 * 
	 * @return next page
	 */
	ArrayList<E> next() {
		if (currentPage * pageSize < myList.size()) {
			currentPage++;
		}
		int start = (currentPage - 1) * pageSize;
		int end;
		if (currentPage * pageSize > myList.size()) {
			end = start + (myList.size() % pageSize);
		} else {
			end = start + pageSize;
		}
		ArrayList<E> lst = new ArrayList<>();
		for (int i = start; i < end; i++) {
			lst.add(myList.get(i));
		}
		return lst;
	}

	/**
	 * Previous page.
	 * 
	 * @return previous page
	 */
	ArrayList<E> previous() {
		if (currentPage == 1) {
			System.out.println("You're on page 1");
		} else {
			currentPage--;
			currentPage--;
			return next();
		}
		return null;
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if there is next page
	 */
	boolean hasNext() {
		return !(currentPage * pageSize == myList.size());
	}

	/**
	 * Checks for previous.
	 * 
	 * @return true, if there is previous page
	 */
	boolean hasPrevious() {
		return !(currentPage == 1);
	}

	/**
	 * First page.
	 * 
	 * @return first page
	 */
	ArrayList<E> firstPage() {
		currentPage = 0;
		return next();
	}

	/**
	 * Last page.
	 * 
	 * @return last page
	 */
	ArrayList<E> lastPage() {
		currentPage = myList.size() / pageSize;
		return next();
	}

	/**
	 * Gets the current page number.
	 * 
	 * @return the current page number
	 */
	int getCurrentPageNumber() {
		return currentPage;
	}
}
