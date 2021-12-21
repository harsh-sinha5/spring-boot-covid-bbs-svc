package com.ibm.bbsrv.TestResponse.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BedDetailRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-05T09:01:10.494Z")


public class BedDetailRequest   {
  @JsonProperty("hospital-name")
  private String hospitalName = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("pincode")
  private String pincode = null;

  public BedDetailRequest hospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
    return this;
  }

  /**
   * Get hospitalName
   * @return hospitalName
  **/
  @ApiModelProperty(value = "")


  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public BedDetailRequest city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BedDetailRequest pincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   * Get pincode
   * @return pincode
  **/
  @ApiModelProperty(value = "")


  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BedDetailRequest bedDetailRequest = (BedDetailRequest) o;
    return Objects.equals(this.hospitalName, bedDetailRequest.hospitalName) &&
        Objects.equals(this.city, bedDetailRequest.city) &&
        Objects.equals(this.pincode, bedDetailRequest.pincode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hospitalName, city, pincode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BedDetailRequest {\n");
    
    sb.append("    hospitalName: ").append(toIndentedString(hospitalName)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
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

