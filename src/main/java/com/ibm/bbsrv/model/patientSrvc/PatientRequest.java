package com.ibm.bbsrv.model.patientSrvc;

public class PatientRequest {

	private String patientFirstName;

	private String patientLastName;

	private String patientContactNumber;

	private String patientEmailId;

	private PatientLocationDetailsRequest patientLocationDetailsReq;

	private PatientIdentificationDetailsRequest patientIdentificationDetailsReq;

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientContactNumber() {
		return patientContactNumber;
	}

	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}

	public String getPatientEmailId() {
		return patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}

	public PatientLocationDetailsRequest getPatientLocationDetailsReq() {
		return patientLocationDetailsReq;
	}

	public void setPatientLocationDetailsReq(PatientLocationDetailsRequest patientLocationDetailsReq) {
		this.patientLocationDetailsReq = patientLocationDetailsReq;
	}

	public PatientIdentificationDetailsRequest getPatientIdentificationDetailsReq() {
		return patientIdentificationDetailsReq;
	}

	public void setPatientIdentificationDetailsReq(
			PatientIdentificationDetailsRequest patientIdentificationDetailsReq) {
		this.patientIdentificationDetailsReq = patientIdentificationDetailsReq;
	}

}
