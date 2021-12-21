package com.ibm.bbsrv.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import com.ibm.bbsrv.TestResponse.model.Branch;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Hospital
 */
public class HospitalOld   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("Branches")
  @Valid
  private List<Branch> branches = null;

  public HospitalOld name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Hospital Name
   * @return name
  **/
  @ApiModelProperty(value = "Hospital Name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HospitalOld branches(List<Branch> branches) {
    this.branches = branches;
    return this;
  }

  public HospitalOld addBranchesItem(Branch branchesItem) {
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
    HospitalOld hospital = (HospitalOld) o;
    return Objects.equals(this.name, hospital.name) &&
        Objects.equals(this.branches, hospital.branches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, branches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hospital {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

