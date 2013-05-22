package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * The Class TestDice.
 */
public class TestDice {
	private static Dice dice = new Dice();

	/**
	 * Return combinations as string.
	 * 
	 * @return the string
	 */
	public static String returnCombinations() {
		String result = "";
		for (String key : dice.getCombinations().keySet()) {
			result += "combination: " + key + " thrown at positions ";
			List<Integer> list = dice.getCombinations().get(key);

			for (int j = 0; j < list.size(); j++) {
				result += list.get(j) + ", ";
			}
			result += "\n";
		}
		result += "number of rolls: " + dice.getCount();
		return result;
	}

	/**
	 * Test dice throwing and combinations.
	 */
	@Test
	public void testCombinations() {
		String in = "1,2";
		assertEquals(false, dice.getCombinations().containsKey(in));
		dice.fillStats(in);
		assertEquals(true, dice.getCombinations().containsKey(in));
		assertEquals(1, (int) dice.getCombinations().get(in).get(0));
		dice.fillStats(in);
		assertEquals(2, (int) dice.getCombinations().get(in).get(1));

		in = "2,3";
		dice.fillStats(in);
		dice.fillStats(in);
		dice.fillStats(in);
		assertEquals(5, (int) dice.getCombinations().get(in).get(2));

		String expected = "combination: 1,2 thrown at positions 1, 2, \ncombination: 2,3 thrown at positions 3, 4, 5, \nnumber of rolls: 5";
		assertEquals(expected, returnCombinations());
	}

}
