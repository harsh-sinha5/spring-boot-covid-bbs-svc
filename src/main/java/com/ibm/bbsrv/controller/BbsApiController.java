package com.ibm.bbsrv.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bbsrv.constants.Constants;
import com.ibm.bbsrv.dao.BedbookingDao;
import com.ibm.bbsrv.entities.BedBooking;
import com.ibm.bbsrv.exception.BedBookingPatientException;
import com.ibm.bbsrv.exception.CustomException;
import com.ibm.bbsrv.exception.PatientPendingException;
import com.ibm.bbsrv.exception.UnAuthorizedException;
import com.ibm.bbsrv.model.AutoConfirmRequest;
import com.ibm.bbsrv.model.BedBookingStatusResponse;
import com.ibm.bbsrv.model.BookingConfirmRequest;
import com.ibm.bbsrv.model.BookingConfirmResponse;
import com.ibm.bbsrv.model.BookingResponse;
import com.ibm.bbsrv.model.BookingUserData;
import com.ibm.bbsrv.model.Error;
import com.ibm.bbsrv.utils.jwtutils.jwtUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T10:00:04.233Z")

@RestController
public class BbsApiController implements BbsApi {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsApiController.class);

	@Autowired
	BbsApi bbsApi;

	@Autowired
	jwtUtil jwtUtil;

	@Autowired
	BedbookingDao bedbookingDao;
	
	@ApiOperation(value = "", nickname = "confirmBooking", notes = "Confirm the booking with booking id. This API will be executed by citizen once they will select and specific bed from specific hospital abd then confirm it", response = BookingConfirmResponse.class, tags = {})
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Returns Booking confirm response when user confirm it.", response = BookingConfirmResponse.class),
	@ApiResponse(code = 400, message = "Invalid input", response = Error.class),
	@ApiResponse(code = 404, message = "School Not Found", response = Error.class),
	@ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/bbs/{bookingId}/_confirm", method = RequestMethod.PUT)
	public BookingConfirmResponse confirmBooking(
			@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details.", required = true) @RequestHeader(value = "X-Token-ID", required = true) String xTokenID,
			@ApiParam(value = "Booking id of booking.", required = true) @PathVariable("bookingId") String bookingId,
			@ApiParam(value = "Patient information to book the bed.", required = true) @Valid @RequestBody BookingConfirmRequest bookingUserData) throws CustomException {
		logger.info("Confirm API Controller Called"+bookingUserData);
		if(jwtUtil.validateRole(Constants.CITIZEN, xTokenID)) {
			return bbsApi.confirmBooking(xTokenID, bookingId, bookingUserData);
		}else{
			throw new UnAuthorizedException("You are not authorized to perform this action");
		}
	}

	@ApiOperation(value = "Delete the booking", nickname = "deleteBooking", notes = "Confirm the booking with booking id", response = Boolean.class, tags = {})
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
	@ApiResponse(code = 400, message = "Invalid input", response = Error.class),
	@ApiResponse(code = 404, message = "School Not Found", response = Error.class),
	@ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/bbs/{bookingId}/_delete", method = RequestMethod.DELETE)
	public Boolean deleteBooking(
			@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details.", required = true) @RequestHeader(value = "X-Token-ID", required = true) String xTokenID,
			@ApiParam(value = "Booking id of booking.", required = true) @PathVariable("bookingId") String bookingId) {
		System.out.println("deleting booking");
		if(jwtUtil.validateRole(Constants.HOSPITAL_ADMIN, xTokenID)) {
			return bbsApi.deleteBooking(xTokenID, bookingId);
		}else{
			throw new UnAuthorizedException("You are not authorized to perform this action");
		}

	}

	@ApiOperation(value = "Get Booking Booking Status", nickname = "getBookingStatus", notes = "Get booking status with booking id", response = BookingConfirmResponse.class, tags = {})
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = BookingConfirmResponse.class),
	@ApiResponse(code = 400, message = "Invalid input", response = Error.class),
	@ApiResponse(code = 404, message = "School Not Found", response = Error.class),
	@ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/bbs/{bookingId}/_status/", method = RequestMethod.GET)
	public BedBookingStatusResponse getBookingStatus(
			@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details.", required = true) @RequestHeader(value = "X-Token-ID", required = true) String xTokenID,
			@ApiParam(value = "Booking id of booking.", required = true) @PathVariable("bookingId") String bookingId) throws CustomException {
		if(jwtUtil.validateRole(Constants.CITIZEN, xTokenID)) {
			return bbsApi.getBookingStatus(xTokenID, bookingId);
		}else{
			throw new UnAuthorizedException("You are not authorized to perform this action");
		}

	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "", nickname = "reserveBed", notes = "This API will be used to book the bed for their ward. Bookign will be done only when the user is logged in. If user is niot logged in then booking will be not done", response = BookingResponse.class, tags = {})
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = BookingResponse.class),
	@ApiResponse(code = 400, message = "Invalid input", response = Error.class),
	@ApiResponse(code = 404, message = "School Not Found", response = Error.class),
	@ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	@RequestMapping(value = "/bbs/_book", method = RequestMethod.POST)
	public BookingResponse reserveBed(
			@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details.", required = true) @RequestHeader(value = "X-Token-ID", required = true) String xTokenID,
			@ApiParam(value = "Patient information to book the bed.", required = true) @Valid @RequestBody BookingUserData bookingUserData) throws CustomException, PatientPendingException, BedBookingPatientException{
		logger.info("Token : " + xTokenID);
		logger.info("Request Received : " + bookingUserData);
		if(jwtUtil.validateRole(Constants.CITIZEN, xTokenID)) {
			return bbsApi.reserveBed(xTokenID, bookingUserData);
		}else{
			throw new UnAuthorizedException("You are not authorized to perform this action");
		}
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "", nickname = "autoConfirm", notes = "This API will be used to auto book the bed when thereis an availability in the hospital bed of a particular pin code",  tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting"),
			@ApiResponse(code = 400, message = "Invalid input", response = Error.class),
			@ApiResponse(code = 404, message = "School Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	@PostMapping("/bbs/_autoConfirm")
	public void autoConfirm(@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details.", required = true) @RequestHeader(value = "X-Token-ID", required = true) String xTokenID,
							@ApiParam(value = "Hospital Infromation for confirmation", required = true)@Valid @RequestBody  AutoConfirmRequest autoConfirmRequest) throws CustomException{
		bbsApi.autoConfirm(xTokenID, autoConfirmRequest);
	}
}
