package com.ibm.bbsrv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bbsrv.entities.BedBooking;
import com.ibm.bbsrv.repository.BedBookingRepo;
import com.ibm.bbsrv.service.BbsApiImpl;

@Component
public class BedbookingDaoImpl implements BedbookingDao {

	private static final Logger logger = LoggerFactory.getLogger(BbsApiImpl.class);

	@Autowired
	BedBookingRepo bedBookingRepo;

	@Override
	public BedBooking findBookingStatus(String patientId) {
		BedBooking bookPatientDetails = bedBookingRepo.findByPatientIdAndStatus(patientId);
		logger.info("BOOK-API: Fetching Booking patient confirmation details");
		return bookPatientDetails;
	}

	@Override
	public BedBooking findBookingPendingStatus(String patientId) {
		BedBooking bookPatientDetails = bedBookingRepo.findByPatientIdAndPendingStatus(patientId);
		logger.info("BOOK-API: Fetching Pending Patient details");
		return bookPatientDetails;
	}

}
