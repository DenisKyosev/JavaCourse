package com.sirma.itt.javacourse.reflections;

// TODO: Auto-generated Javadoc
/**
 * Run Class for SortClasses.
 */
public final class RunSortClasses {

	/**
	 * Instantiates a new run sort classes.
	 */
	private RunSortClasses() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SortClasses srt = new SortClasses();
		ParentClass[] classes= {new ClassTwo(), new ClassOne(), new ClassThree()};
		ParentClass[] sorted = srt.sort(classes);
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}

	}

}
