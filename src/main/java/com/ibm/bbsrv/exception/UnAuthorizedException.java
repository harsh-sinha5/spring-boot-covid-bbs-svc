package com.ibm.bbsrv.exception;

public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String msg) {
        super(msg);
    }
}
