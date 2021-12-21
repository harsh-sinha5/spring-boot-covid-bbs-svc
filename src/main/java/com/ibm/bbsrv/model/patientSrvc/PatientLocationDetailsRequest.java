package com.ibm.bbsrv.model.patientSrvc;

public class PatientLocationDetailsRequest {

	private String cityName;

	private String pinNumber;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

}
