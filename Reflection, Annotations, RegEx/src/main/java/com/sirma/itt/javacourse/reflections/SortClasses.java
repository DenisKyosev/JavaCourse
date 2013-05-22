package com.sirma.itt.javacourse.reflections;

import java.lang.annotation.Annotation;

// TODO: Auto-generated Javadoc
/**
 * SortClasses.
 */
public class SortClasses {

	/**
	 * Sort classes.
	 */
	public void sortClasses() {
		ParentClass[] classes = { new ClassTwo(), new ClassOne(), new ClassThree() };
		int temp;
		ParentClass tempname;
		int[] annotationsArray = new int[classes.length];
		for (int i = 0; i < classes.length; i++) {

			@SuppressWarnings("rawtypes")
			Class myClass = classes[i].getClass();
			Annotation[] ann = myClass.getAnnotations();

			for (Annotation annotation : ann) {
				if (annotation instanceof sorted) {
					sorted myAnnotation = (sorted) annotation;
					annotationsArray[i] = myAnnotation.id();
				}
			}

		}

		for (int i = 0; i < annotationsArray.length - 1; i++) {
			for (int j = 1; j < annotationsArray.length; j++) {
				if (annotationsArray[i] > annotationsArray[j]) {

					temp = annotationsArray[i];
					tempname = classes[i];
					annotationsArray[i] = annotationsArray[j];

					classes[i] = classes[j];
					annotationsArray[j] = temp;
					classes[j] = tempname;
				}
			}
		}

		for (int i = 0; i < classes.length; i++) {
			System.out.println(classes[i]);
		}
	}
}
