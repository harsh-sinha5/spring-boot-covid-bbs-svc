package com.ibm.bbsrv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingConfirmRequest {
	 
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
		return "BookingConfirmRequest [hospitalName=" + hospitalName + ", hospitalId=" + hospitalId
				+ ", hospitalBranchId=" + hospitalBranchId + ", locationDetail=" + locationDetail + ", bed=" + bed
				+ "]";
	}
	  
}
