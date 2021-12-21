package com.ibm.bbsrv.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ibm.bbsrv.model.Branch;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Hospital
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-12T05:56:56.660Z")


public class Hospital   {
  @JsonProperty("hospitalName")
  private String hospitalName = null;

  @JsonProperty("hospitalId")
  private String hospitalId = null;

  @JsonProperty("Branches")
  @Valid
  private List<Branch> branches = null;

  public Hospital hospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
    return this;
  }

  /**
   * Hospital Name
   * @return hospitalName
  **/
  @ApiModelProperty(value = "Hospital Name")


  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public Hospital hospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
    return this;
  }

  /**
   * Get hospitalId
   * @return hospitalId
  **/
  @ApiModelProperty(value = "")


  public String getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
  }

  public Hospital branches(List<Branch> branches) {
    this.branches = branches;
    return this;
  }

  public Hospital addBranchesItem(Branch branchesItem) {
    if (this.branches == null) {
      this.branches = new ArrayList<Branch>();
    }
    this.branches.add(branchesItem);
    return this;
  }

  /**
   * List of Bed objects.
   * @return branches
  **/
  @ApiModelProperty(value = "List of Bed objects.")

  @Valid

  public List<Branch> getBranches() {
    return branches;
  }

  public void setBranches(List<Branch> branches) {
    this.branches = branches;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hospital hospital = (Hospital) o;
    return Objects.equals(this.hospitalName, hospital.hospitalName) &&
        Objects.equals(this.hospitalId, hospital.hospitalId) &&
        Objects.equals(this.branches, hospital.branches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hospitalName, hospitalId, branches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hospital {\n");
    
    sb.append("    hospitalName: ").append(toIndentedString(hospitalName)).append("\n");
    sb.append("    hospitalId: ").append(toIndentedString(hospitalId)).append("\n");
    sb.append("    branches: ").append(toIndentedString(branches)).append("\n");
    sb.append("}");
    return sb.toString();
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

