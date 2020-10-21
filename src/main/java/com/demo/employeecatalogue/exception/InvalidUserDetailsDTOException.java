package com.demo.employeecatalogue.exception;

public class InvalidUserDetailsDTOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4325484536353914005L;

	public InvalidUserDetailsDTOException() {
		super();
	}
	
	public InvalidUserDetailsDTOException(String msg) {
		super(msg);
	}
}
