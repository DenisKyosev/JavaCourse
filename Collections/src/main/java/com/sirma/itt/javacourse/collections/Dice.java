package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Dice.
 */
public class Dice {

	/** The combinations. */
	private static Map<String, List<Integer>> combinations = new HashMap<String, List<Integer>>();

	/** The count. */
	private static Integer count = 0;

	/**
	 * Getter method for combinations.
	 * 
	 * @return the combinations
	 */
	public Map<String, List<Integer>> getCombinations() {
		return combinations;
	}

	/**
	 * Setter method for combinations.
	 * 
	 * @param combinations
	 *            the combinations to set
	 */
	public static void setCombinations(Map<String, List<Integer>> combinations) {
		Dice.combinations = combinations;
	}

	/**
	 * Getter method for count.
	 * 
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Setter method for count.
	 * 
	 * @param count
	 *            the count to set
	 */
	public static void setCount(Integer count) {
		Dice.count = count;
	}

	/**
	 * Throw dice.
	 * 
	 * @return the string
	 */
	public static String throwDice() {
		Integer[] dice = new Integer[2];
		dice[0] = (int) (Math.random() * 6);
		if (dice[0] < 1) {
			dice[0] = 1;
		}
		dice[1] = (int) (Math.random() * 6);
		if (dice[1] < 1) {
			dice[1] = 1;
		}
		return Integer.toString(dice[0]) + "," + Integer.toString(dice[1]);
	}

	/**
	 * Fill stats.
	 */
	public static void fillStats() {
		String dice = throwDice();
		count++;

		List<Integer> l = combinations.get(dice);
		if (l == null) {
			l = new ArrayList<Integer>();
			combinations.put(dice, l);
		}

		l.add(count);
		combinations.put(dice, l);
	}

	/**
	 * Fill stats.
	 * 
	 * @param diceThrow
	 *            the dice throw combination
	 */
	public void fillStats(String diceThrow) {
		String dice = diceThrow;
		count++;

		List<Integer> l = combinations.get(dice);
		if (l == null) {
			l = new ArrayList<Integer>();
			combinations.put(dice, l);
		}

		l.add(count);
		combinations.put(dice, l);
	}
}
