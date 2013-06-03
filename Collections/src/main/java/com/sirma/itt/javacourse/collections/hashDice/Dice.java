package com.sirma.itt.javacourse.collections.hashDice;

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
	public void setCombinations(Map<String, List<Integer>> combinations) {
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
	public void setCount(Integer count) {
		Dice.count = count;
	}

	/**
	 * Throw dice.
	 */
	public void throwDice() {
		Integer[] dice = new Integer[2];
		dice[0] = (int) (Math.random() * 6);
		if (dice[0] < 1) {
			dice[0] = 1;
		}
		dice[1] = (int) (Math.random() * 6);
		if (dice[1] < 1) {
			dice[1] = 1;
		}
		fillStats(Integer.toString(dice[0]) + "," + Integer.toString(dice[1]));
	}

	/**
	 * Fill stats.
	 * 
	 * @param diceThrow
	 *            the dice throw combination
	 */
	public void fillStats(String diceThrow) {
		String dice = diceThrow;
		String dice2 = diceThrow.charAt(2) + "," + diceThrow.charAt(0);

		count++;
		List<Integer> l;

		if (combinations.get(dice2) != null) {
			l = combinations.get(dice2);
		} else {
			l = combinations.get(dice);
		}
		if (l == null) {
			l = new ArrayList<Integer>();
			if (combinations.get(dice2) != null) {
				combinations.put(dice2, l);
			} else {
				combinations.put(dice, l);
			}
		}

		l.add(count);

		if (combinations.get(dice2) != null) {
			combinations.put(dice2, l);
		} else {
			combinations.put(dice, l);
		}
	}
}
