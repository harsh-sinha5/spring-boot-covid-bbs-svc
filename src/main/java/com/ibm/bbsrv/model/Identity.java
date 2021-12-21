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
 * Identity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T10:00:04.233Z")


public class Identity   {
  @JsonProperty("pan_number")
  private String panNumber = null;

  @JsonProperty("aadhar_card")
  private String aadharCard = null;

  public Identity panNumber(String panNumber) {
    this.panNumber = panNumber;
    return this;
  }

  /**
   * Patient PAN number
   * @return panNumber
  **/
  @ApiModelProperty(value = "Patient PAN number")


  public String getPanNumber() {
    return panNumber;
  }

  public void setPanNumber(String panNumber) {
    this.panNumber = panNumber;
  }

  public Identity aadharCard(String aadharCard) {
    this.aadharCard = aadharCard;
    return this;
  }

  /**
   * Patient aadhar card
   * @return aadharCard
  **/
  @ApiModelProperty(value = "Patient aadhar card")


  public String getAadharCard() {
    return aadharCard;
  }

  public void setAadharCard(String aadharCard) {
    this.aadharCard = aadharCard;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return Objects.equals(this.panNumber, identity.panNumber) &&
        Objects.equals(this.aadharCard, identity.aadharCard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(panNumber, aadharCard);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identity {\n");
    
    sb.append("    panNumber: ").append(toIndentedString(panNumber)).append("\n");
    sb.append("    aadharCard: ").append(toIndentedString(aadharCard)).append("\n");
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

