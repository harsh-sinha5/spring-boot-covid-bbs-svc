package com.ibm.bbsrv.model.patientSrvc;

public class PatientIdentificationDetailsRequest {

	private String panNumber;

	private String aadharNumber;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

}
