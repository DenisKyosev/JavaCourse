package com.sirma.itt.javacourse.designpatterns;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyClass {
	protected Set set;

	protected MyClass(String x) {
		if (x.equals("String")) {
			this.set = new HashSet<String>();
		} else if (x.equals("Integer")) {
			this.set = new HashSet<Integer>();
		} else {
			this.set = new HashSet<Object>();
		}

	}

	protected MyClass() {
		this.set = new LinkedHashSet<String>();
	}
}
