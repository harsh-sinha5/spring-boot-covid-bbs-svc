package com.ibm.bbsrv.exception;

public class InvalidPatientException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidPatientException(String msg) {
        super(msg);
    }
}
