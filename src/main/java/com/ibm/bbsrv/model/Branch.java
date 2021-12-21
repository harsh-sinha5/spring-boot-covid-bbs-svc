package com.ibm.bbsrv.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ibm.bbsrv.model.Bed;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Branch
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-12T05:56:56.660Z")


public class Branch   {
  @JsonProperty("branchName")
  private String branchName = null;

  @JsonProperty("branchId")
  private String branchId = null;

  @JsonProperty("Beds")
  @Valid
  private List<Bed> beds = null;

  public Branch branchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  /**
   * Get branchName
   * @return branchName
  **/
  @ApiModelProperty(value = "")


  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public Branch branchId(String branchId) {
    this.branchId = branchId;
    return this;
  }

  /**
   * Get branchId
   * @return branchId
  **/
  @ApiModelProperty(value = "")


  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public Branch beds(List<Bed> beds) {
    this.beds = beds;
    return this;
  }

  public Branch addBedsItem(Bed bedsItem) {
    if (this.beds == null) {
      this.beds = new ArrayList<Bed>();
    }
    this.beds.add(bedsItem);
    return this;
  }

  /**
   * Get beds
   * @return beds
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Bed> getBeds() {
    return beds;
  }

  public void setBeds(List<Bed> beds) {
    this.beds = beds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Branch branch = (Branch) o;
    return Objects.equals(this.branchName, branch.branchName) &&
        Objects.equals(this.branchId, branch.branchId) &&
        Objects.equals(this.beds, branch.beds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchName, branchId, beds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Branch {\n");
    
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    beds: ").append(toIndentedString(beds)).append("\n");
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

