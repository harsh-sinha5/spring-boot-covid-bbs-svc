package com.ibm.bbsrv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bbsrv.entities.BedBooking;

@Repository
public interface BedBookingRepo extends JpaRepository<BedBooking, String> {

	public BedBooking findByBookingID(String id);
	// public BedBooking findByPatientID(String id);

	@Query("SELECT COUNT(*)+1 FROM BedBooking bb WHERE bb.status='pending'")
	long getWaitingNumber();

	@Transactional
	@Query("SELECT b FROM BedBooking b WHERE b.patientId = :patientId AND b.status='confirmed'")
	public BedBooking findByPatientIdAndStatus(@Param("patientId") String patientId);
	
	@Transactional
	@Query("SELECT b FROM BedBooking b WHERE b.patientId = :patientId AND b.status='pending'")
	public BedBooking findByPatientIdAndPendingStatus(@Param("patientId") String patientId);
}
