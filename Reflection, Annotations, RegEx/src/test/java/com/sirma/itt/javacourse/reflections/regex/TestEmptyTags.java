package com.sirma.itt.javacourse.reflections.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestEmptyTags.
 */
public class TestEmptyTags {

	private final EmptyTags empty = new EmptyTags();

	/**
	 * Test empty tags.
	 */
	@Test
	public void testEmptyTags() {
		String code = "<x><b></b><x>Hello world</x>" + "<b>sdfsdf</b><x>Good"
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>" + "</x>";
		String expected = "<x><b></b><x/>" + "<b>sdfsdf</b><x/><x/><x/>" + "</x>";
		assertEquals(expected, empty.emptyTag(code));
	}
}
