package com.ibm.bbsrv.dao;

import com.ibm.bbsrv.entities.BedBooking;

public interface BedbookingDao {

	public BedBooking findBookingStatus(String patientId);
	public BedBooking findBookingPendingStatus(String patientId);

}
