package com.sirma.itt.javacourse.designpatterns;

public class MyClassFactory {
	MyClass myClass = new MyClass();

	MyClass createInstance() {
		return new MyClass();
	}

	MyClass createInstance(String str) {
		return new MyClass(str);
	}
}
