package com.sirma.itt.javacourse.inputoutput;

import java.io.Serializable;

/**
 * The Class UserDefinedObject.
 */
public class UserDefinedObject implements Serializable {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The var. */
	private String var;

	/**
	 * Instantiates a new user defined object.
	 * 
	 * @param var
	 *            string
	 */
	public UserDefinedObject(String var) {
		this.var = var;
	}

	/**
	 * Getter method for var.
	 * 
	 * @return the var
	 */
	public String getVar() {
		return var;
	}

	/**
	 * Setter method for var.
	 * 
	 * @param var
	 *            the var to set
	 */
	public void setVar(String var) {
		this.var = var;
	}
}
