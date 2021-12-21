package com.ibm.bbsrv.model;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PatientUpdate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-11T07:36:39.824Z")


public class PatientUpdate   {

	@JsonProperty("booking-id")
	private String bedBookingId;

	@JsonProperty("vaccine-booking-id")
	private String vaccineBookingId;

	@JsonProperty("hospital-name")
	private String hospitalName = null;

	@JsonProperty("status")
	private String vaccinationStatus = null;
	
	public PatientUpdate(String bedBookingId, String vaccineBookingId, String hospitalName, String vaccinationStatus) {
		super();
		this.bedBookingId = bedBookingId;
		this.vaccineBookingId = vaccineBookingId;
		this.hospitalName = hospitalName;
		this.vaccinationStatus = vaccinationStatus;
	}

	public PatientUpdate(String bedBookingId, String hospitalName) {
		super();
		this.bedBookingId = bedBookingId;
		this.hospitalName = hospitalName;
	}
	
	

	public PatientUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBedBookingId() {
		return bedBookingId;
	}

	public void setBedBookingId(String bedBookingId) {
		this.bedBookingId = bedBookingId;
	}

	public String getVaccineBookingId() {
		return vaccineBookingId;
	}

	public void setVaccineBookingId(String vaccineBookingId) {
		this.vaccineBookingId = vaccineBookingId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	@Override
	public String toString() {
		return "PatientUpdate [bedBookingId=" + bedBookingId + ", vaccineBookingId=" + vaccineBookingId
				+ ", hospitalName=" + hospitalName + ", vaccinationStatus=" + vaccinationStatus + "]";
	}
	
	
}

