package com.sirma.itt.javacourse.reflections;

/**
 * ParentClass.
 */
public class ParentClass implements Comparable<ParentClass>{



	public int compareTo(ParentClass o) {
		return this.getClass().getAnnotation(sorted.class).id()
				- ((ParentClass) o).getClass().getAnnotation(sorted.class).id();
	}
	
}
