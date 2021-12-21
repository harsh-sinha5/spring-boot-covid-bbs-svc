package com.ibm.bbsrv.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutoConfirmRequest {
	 
	  @JsonProperty("hospital-name")
	  private String hospitalName = null;
	
	  @JsonProperty("hospital-id")
	  private String hospitalId = null;

	  @JsonProperty("hospital-branch-id")
	  private String hospitalBranchId = null;

	  @JsonProperty("LocationDetail")
	  private Location locationDetail = null;

	  @JsonProperty("Bed")
	  private List<Bed> bed = null;
	  

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

	

	public List<Bed> getBed() {
		return bed;
	}

	public void setBed(List<Bed> bed) {
		this.bed = bed;
	}

	@Override
	public String toString() {
		return "AutoConfirmRequest [hospitalName=" + hospitalName + ", hospitalId=" + hospitalId + ", hospitalBranchId="
				+ hospitalBranchId + ", locationDetail=" + locationDetail + ", bed=" + bed + "]";
	}

	
	  
}
