package com.sirma.itt.javacourse.designpatterns.proxy;

public class RunIntegerProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerFactory proxy = new IntegerFactory();
		System.out.println(proxy.createInstance().getRealNumber());
	}

}
