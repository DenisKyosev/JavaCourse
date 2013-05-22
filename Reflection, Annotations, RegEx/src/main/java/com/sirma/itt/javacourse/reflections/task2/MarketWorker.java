package com.sirma.itt.javacourse.reflections.task2;

import java.util.List;

/**
 * all workers in the market.
 * 
 * @author Fester
 */
public interface MarketWorker {
	/**
	 * worker's shedule.
	 * 
	 * @return shedule
	 */
	List<String> shedule();

	/**
	 * salary.
	 * 
	 * @return salary
	 */
	int salary();
}
