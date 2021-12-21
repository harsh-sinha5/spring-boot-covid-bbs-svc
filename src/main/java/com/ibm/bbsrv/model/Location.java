package com.ibm.bbsrv.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Location
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T10:00:04.233Z")


public class Location   {
  @JsonProperty("city_name")
  private String cityName = null;

  @JsonProperty("pin_number")
  private String pinNumber = null;

  public Location cityName(String cityName) {
    this.cityName = cityName;
    return this;
  }

  /**
   * City Name
   * @return cityName
  **/
  @ApiModelProperty(value = "City Name")


  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Location pinNumber(String pinNumber) {
    this.pinNumber = pinNumber;
    return this;
  }

  /**
   * Location PIN number
   * @return pinNumber
  **/
  @ApiModelProperty(value = "Location PIN number")


  public String getPinNumber() {
    return pinNumber;
  }

  public void setPinNumber(String pinNumber) {
    this.pinNumber = pinNumber;
  }

  public Location(String cityName, String pinNumber) {
	super();
	this.cityName = cityName;
	this.pinNumber = pinNumber;
  }

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.cityName, location.cityName) &&
        Objects.equals(this.pinNumber, location.pinNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cityName, pinNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    cityName: ").append(toIndentedString(cityName)).append("\n");
    sb.append("    pinNumber: ").append(toIndentedString(pinNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public Location() {
	super();}
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

