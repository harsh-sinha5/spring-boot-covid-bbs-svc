package com.ibm.bbsrv.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bedbooking")
public class BedBooking {
	
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "bookingid")
	private String bookingID;
	
	@Column(name = "status")
	private String status;
	@Column(name = "guardianID")
	private String guardianID;
	/*@Column(name = "waitingNum")
	private String waitingNum;*/
	
/*	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "patient")*/
    private String patientId;

    @Column(name = "patient_pin_code")
	private String patientPinCode;
    @Column(name = "booking_date_time")
	private Timestamp bookingDateTime;

	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGuardianID() {
		return guardianID;
	}
	public void setGuardianID(String guardianID) {
		this.guardianID = guardianID;
	}

	@Override
	public String toString() {
		return "BedBooking{" +
				"bookingID='" + bookingID + '\'' +
				", status='" + status + '\'' +
				", guardianID='" + guardianID + '\'' +
				", patientId='" + patientId + '\'' +
				", patientPinCode='" + patientPinCode + '\'' +
				", bookingDateTime=" + bookingDateTime +
				'}';
	}

	public String getPatientPinCode() {
		return patientPinCode;
	}

	public void setPatientPinCode(String patientPinCode) {
		this.patientPinCode = patientPinCode;
	}

	public Timestamp getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(Timestamp bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}
	
	
	/*public String getWaitingNum() {
		return waitingNum;
	}
	public void setWaitingNum(String waitingNum) {
		this.waitingNum = waitingNum;
	}*/
	
	

}
