package com.ibm.bbsrv.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bas Response for Bed Booking Status API
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-09T09:27:51.674Z")

public class BasStatusResponse {

	@JsonProperty("Hospital")
	private HospitalConfirm hospital = null;

	public BasStatusResponse() {

	}

	public BasStatusResponse(HospitalConfirm hospital) {
		super();
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "BasStatusResponse [hospital=" + hospital + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hospital);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasStatusResponse other = (BasStatusResponse) obj;
		return Objects.equals(hospital, other.hospital);
	}

	public HospitalConfirm getHospital() {
		return hospital;
	}

	public void setHospital(HospitalConfirm hospital) {
		this.hospital = hospital;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
