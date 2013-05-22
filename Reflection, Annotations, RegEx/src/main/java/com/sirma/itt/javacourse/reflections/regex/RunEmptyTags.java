package com.sirma.itt.javacourse.reflections.regex;

// TODO: Auto-generated Javadoc
/**
 * The Class RunEmptyTags.
 */
public final class RunEmptyTags {

	/**
	 * Instantiates a new run empty tags.
	 */
	private RunEmptyTags() {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EmptyTags empty = new EmptyTags();
		String code = "<x><b></b><x>Hello world</x>" + "<b>sdfsdf</b><x>Good"
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>" + "</x>";
		System.out.println(empty.emptyTag(code));
	}

}
