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
 * Bed
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-05T09:01:10.494Z")


public class Bed   {
  @JsonProperty("bed-id")
  private String bedId = null;

  @JsonProperty("bed-type")
  private String bedType = null;

  @JsonProperty("bed-facility")
  private String bedFacility = null;

  public Bed bedId(String bedId) {
    this.bedId = bedId;
    return this;
  }

  /**
   * Get bedId
   * @return bedId
  **/
  @ApiModelProperty(value = "")


  public String getBedId() {
    return bedId;
  }

  public void setBedId(String bedId) {
    this.bedId = bedId;
  }

  public Bed bedType(String bedType) {
    this.bedType = bedType;
    return this;
  }

  /**
   * Bed type (Single, Double, General)
   * @return bedType
  **/
  @ApiModelProperty(value = "Bed type (Single, Double, General)")


  public String getBedType() {
    return bedType;
  }

  public void setBedType(String bedType) {
    this.bedType = bedType;
  }

  public Bed bedFacility(String bedFacility) {
    this.bedFacility = bedFacility;
    return this;
  }

  /**
   * With (Oxygen, Ventilator, None)
   * @return bedFacility
  **/
  @ApiModelProperty(value = "With (Oxygen, Ventilator, None)")


  public String getBedFacility() {
    return bedFacility;
  }

  public void setBedFacility(String bedFacility) {
    this.bedFacility = bedFacility;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bed bed = (Bed) o;
    return Objects.equals(this.bedId, bed.bedId) &&
        Objects.equals(this.bedType, bed.bedType) &&
        Objects.equals(this.bedFacility, bed.bedFacility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bedId, bedType, bedFacility);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bed {\n");
    
    sb.append("    bedId: ").append(toIndentedString(bedId)).append("\n");
    sb.append("    bedType: ").append(toIndentedString(bedType)).append("\n");
    sb.append("    bedFacility: ").append(toIndentedString(bedFacility)).append("\n");
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

