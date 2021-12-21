package com.ibm.bbsrv.TestResponse.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ibm.bbsrv.TestResponse.model.Hospital;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BedAvailableInPinCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-11T08:32:26.275Z")


public class BedAvailableInPinCode   {
  @JsonProperty("Hospitals")
  @Valid
  private List<Hospital> hospitals = null;

  public BedAvailableInPinCode hospitals(List<Hospital> hospitals) {
    this.hospitals = hospitals;
    return this;
  }

  public BedAvailableInPinCode addHospitalsItem(Hospital hospitalsItem) {
    if (this.hospitals == null) {
      this.hospitals = new ArrayList<Hospital>();
    }
    this.hospitals.add(hospitalsItem);
    return this;
  }

  /**
   * Get hospitals
   * @return hospitals
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Hospital> getHospitals() {
    return hospitals;
  }

  public void setHospitals(List<Hospital> hospitals) {
    this.hospitals = hospitals;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BedAvailableInPinCode bedAvailableInPinCode = (BedAvailableInPinCode) o;
    return Objects.equals(this.hospitals, bedAvailableInPinCode.hospitals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hospitals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BedAvailableInPinCode {\n");
    
    sb.append("    hospitals: ").append(toIndentedString(hospitals)).append("\n");
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

