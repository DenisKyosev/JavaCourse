package com.sirma.itt.javacourse.reflections.regex;

/**
 * EmptyTags x.
 */
public class EmptyTags {

	/**
	 * Empty tag.
	 * 
	 * @param str
	 *            string to be checked
	 * @return new string
	 */
	public String emptyTag(String str) {
		String pattern = "<x>[^<]*[^>]</x>";
		String newStr = str.replaceAll(pattern, "<x/>");
		return newStr;
	}

}
