package com.ibm.bbsrv.exception;

public class InvalidRequestException extends RuntimeException{

    public InvalidRequestException(String msg) {
        super(msg);
    }
}
