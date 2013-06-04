package com.sirma.itt.javacourse.collections.pageBean;

import java.util.ArrayList;
import java.util.logging.Logger;

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
	private final int pageSize;

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
	 * Gets the items.
	 * 
	 * @return the items
	 */
	public ArrayList<E> getItems() {
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
	 * Next page.
	 * 
	 * @return next page
	 */
	public ArrayList<E> next() {
		if (hasNext()) {
			currentPage++;
		}
		return getItems();
	}

	/**
	 * Previous page.
	 * 
	 * @return previous page
	 */
	public ArrayList<E> previous() {
		if (currentPage <= 1) {
			Logger log = Logger.getLogger("con.sirma.itt");
			log.info("You're on page 1");
		} else {
			currentPage--;

			return getItems();
		}
		return null;
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if there is next page
	 */
	public boolean hasNext() {
		return !(currentPage * pageSize == myList.size());
	}

	/**
	 * Checks for previous.
	 * 
	 * @return true, if there is previous page
	 */
	public boolean hasPrevious() {
		return !(currentPage == 1);
	}

	/**
	 * First page.
	 * 
	 * @return first page
	 */
	public ArrayList<E> firstPage() {
		currentPage = 1;
		return getItems();
	}

	/**
	 * Last page.
	 * 
	 * @return last page
	 */
	public ArrayList<E> lastPage() {
		if (myList.size() % pageSize > 0) {
			currentPage = (myList.size() / pageSize) + 1;
		} else {
			currentPage = myList.size() / pageSize;
		}
		System.out.println(currentPage);
		return getItems();
	}

	/**
	 * Gets the current page number.
	 * 
	 * @return the current page number
	 */
	public int getCurrentPageNumber() {
		return currentPage;
	}
}
