package com.sirma.itt.javacourse.reflections.task4;


// TODO: Auto-generated Javadoc
/**
 * ParentClass.
 */
public class ParentClass implements Comparable<ParentClass> {

	/**
	 * comparable overload.
	 * 
	 * @param o
	 *            class to be compared
	 * @return difference
	 */
	public int compareTo(ParentClass o) {
		return this.getClass().getAnnotation(sorted.class).id()
				- o.getClass().getAnnotation(sorted.class).id();
	}

}
