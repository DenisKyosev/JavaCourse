package com.sirma.itt.javacourse.designpatterns;

import java.util.Scanner;

public class RunMyClassFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyClassFactory fac = new MyClassFactory();
		Scanner sc = new Scanner(System.in);
		fac.createInstance("String");
	}

}
