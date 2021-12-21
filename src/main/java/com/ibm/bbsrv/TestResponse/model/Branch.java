package com.ibm.bbsrv.TestResponse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Branch
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-05T09:01:10.494Z")


public class Branch   {
  @JsonProperty("branchId")
  private String branchId = null;

  @JsonProperty("Location")
  private Location location = null;

  @JsonProperty("Beds")
  @Valid
  private List<Bed> beds = null;

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

  public Branch location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
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
    return Objects.equals(this.branchId, branch.branchId) &&
        Objects.equals(this.location, branch.location) &&
        Objects.equals(this.beds, branch.beds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchId, location, beds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Branch {\n");
    
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

