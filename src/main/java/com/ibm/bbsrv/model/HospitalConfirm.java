package com.ibm.bbsrv.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HospitalConfirm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-11T13:12:39.773Z")

public class HospitalConfirm {

	@JsonProperty("hospital-name")
	private String hospitalName = null;

	@JsonProperty("hospital-id")
	private String hospitalId = null;

	@JsonProperty("hospital-branch-id")
	private String hospitalBranchId = null;

	@JsonProperty("LocationDetail")
	private Location locationDetail = null;

	@JsonProperty("Bed")
	private Bed bed = null;

	public HospitalConfirm(String hospitalName, String hospitalId, String hospitalBranchId, Location locationDetail,
			Bed bed) {
		super();
		this.hospitalName = hospitalName;
		this.hospitalId = hospitalId;
		this.hospitalBranchId = hospitalBranchId;
		this.locationDetail = locationDetail;
		this.bed = bed;
	}

	public HospitalConfirm() {
		super();
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalBranchId() {
		return hospitalBranchId;
	}

	public void setHospitalBranchId(String hospitalBranchId) {
		this.hospitalBranchId = hospitalBranchId;
	}

	public Location getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(Location locationDetail) {
		this.locationDetail = locationDetail;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	@Override
	public String toString() {
		return "HospitalConfirm [hospitalName=" + hospitalName + ", hospitalId=" + hospitalId + ", hospitalBranchId="
				+ hospitalBranchId + ", locationDetail=" + locationDetail + ", bed=" + bed + "]";
	}

}
