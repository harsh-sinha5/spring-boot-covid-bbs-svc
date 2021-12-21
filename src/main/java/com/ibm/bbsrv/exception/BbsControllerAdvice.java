package com.ibm.bbsrv.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice

public class BbsControllerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BbsControllerAdvice.class);

	@ExceptionHandler(UnAuthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public Error userExistsException(UnAuthorizedException ex) {
		Error error = new Error(400, ex.getMessage());
		return error;
	}

	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Error tokenExpired(ExpiredJwtException ex) {
		Error error = new Error(406, ex.getMessage(), "X-Token-ID");
		return error;
	}

	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public Error invalidRequestException(InvalidRequestException ex) {
		Error error = new Error(406, ex.getMessage(), "Location Details");
		return error;
	}

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	public Error handleBedBookingException(CustomException ce) {
		Error error = new Error(503, ce.getMessage(), "");
		logger.info("inside BBS advisor class :--");
		return error;
	}
	
	@ExceptionHandler(PatientPendingException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Error patientPendingException(PatientPendingException ex) {
		Error error = new Error(400, ex.getMessage(), "While Rebooking bed to patient");
		return error;
	}
	
	@ExceptionHandler(BedBookingPatientException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Error bookingBedPatientException(BedBookingPatientException ex) {
		Error error = new Error(400, ex.getMessage(), "Booking bed to patient");
		return error;
	}
	
	/*@ExceptionHandler(InvalidPatientException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Error invalidPatientException(InvalidPatientException ex) {
		Error error = new Error(400, ex.getMessage(), "Booking bed to patient");
		return error;
	}*/

	
}
