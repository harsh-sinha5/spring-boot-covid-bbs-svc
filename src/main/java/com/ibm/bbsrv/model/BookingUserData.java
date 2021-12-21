package com.ibm.bbsrv.model;

import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * BookingUserData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T10:00:04.233Z")


public class BookingUserData   {
	
   @JsonProperty("patient_Id")
   private String patientId = null;
	
  @JsonProperty("patient_first_name")
  private String patientFirstName = null;

  @JsonProperty("patient_last_name")
  private String patientLastName = null;

  @JsonProperty("patient_contact_number")
  private String patientContactNumber = null;

  @JsonProperty("patient_email_id")
  private String patientEmailId = null;
  
  @JsonProperty("date_Of_Birth")
  private String dateOfBirth;
  
  @JsonProperty("state")
  private String state;

  @JsonProperty("patient_LocationDetails")
  private Location patientLocationDetails = null;

  @JsonProperty("patient_IdentificationDetail")
  private Identity patientIdentificationDetail = null;

  
  
  public String getPatientId() {
	return patientId;
}

public void setPatientId(String patientId) {
	this.patientId = patientId;
}

public BookingUserData patientFirstName(String patientFirstName) {
    this.patientFirstName = patientFirstName;
    return this;
  }

  /**
   * User first name
   * @return patientFirstName
  **/
  @ApiModelProperty(value = "User first name")


  public String getPatientFirstName() {
    return patientFirstName;
  }

  public void setPatientFirstName(String patientFirstName) {
    this.patientFirstName = patientFirstName;
  }

  public BookingUserData patientLastName(String patientLastName) {
    this.patientLastName = patientLastName;
    return this;
  }

  /**
   * User last name
   * @return patientLastName
  **/
  @ApiModelProperty(value = "User last name")


  public String getPatientLastName() {
    return patientLastName;
  }

  public void setPatientLastName(String patientLastName) {
    this.patientLastName = patientLastName;
  }

  public BookingUserData patientContactNumber(String patientContactNumber) {
    this.patientContactNumber = patientContactNumber;
    return this;
  }

  /**
   * User contact number
   * @return patientContactNumber
  **/
  @ApiModelProperty(value = "User contact number")


  public String getPatientContactNumber() {
    return patientContactNumber;
  }

  public void setPatientContactNumber(String patientContactNumber) {
    this.patientContactNumber = patientContactNumber;
  }

  public BookingUserData patientEmailId(String patientEmailId) {
    this.patientEmailId = patientEmailId;
    return this;
  }

  /**
   * User email id
   * @return patientEmailId
  **/
  @ApiModelProperty(value = "User email id")


  public String getPatientEmailId() {
    return patientEmailId;
  }

  public void setPatientEmailId(String patientEmailId) {
    this.patientEmailId = patientEmailId;
  }

  public String getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public BookingUserData patientLocationDetails(Location patientLocationDetails) {
    this.patientLocationDetails = patientLocationDetails;
    return this;
  }

  /**
   * Get patientLocationDetails
   * @return patientLocationDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Location getPatientLocationDetails() {
    return patientLocationDetails;
  }

  public void setPatientLocationDetails(Location patientLocationDetails) {
    this.patientLocationDetails = patientLocationDetails;
  }

  public BookingUserData patientIdentificationDetail(Identity patientIdentificationDetail) {
    this.patientIdentificationDetail = patientIdentificationDetail;
    return this;
  }

  /**
   * Get patientIdentificationDetail
   * @return patientIdentificationDetail
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Identity getPatientIdentificationDetail() {
    return patientIdentificationDetail;
  }

  public void setPatientIdentificationDetail(Identity patientIdentificationDetail) {
    this.patientIdentificationDetail = patientIdentificationDetail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingUserData bookingUserData = (BookingUserData) o;
    return Objects.equals(this.patientFirstName, bookingUserData.patientFirstName) &&
        Objects.equals(this.patientLastName, bookingUserData.patientLastName) &&
        Objects.equals(this.patientContactNumber, bookingUserData.patientContactNumber) &&
        Objects.equals(this.patientEmailId, bookingUserData.patientEmailId) &&
        Objects.equals(this.state, bookingUserData.state) &&
        Objects.equals(this.dateOfBirth, bookingUserData.dateOfBirth) &&
        Objects.equals(this.patientLocationDetails, bookingUserData.patientLocationDetails) &&
        Objects.equals(this.patientIdentificationDetail, bookingUserData.patientIdentificationDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientFirstName, patientLastName, patientContactNumber, patientEmailId, state,  dateOfBirth, patientLocationDetails, patientIdentificationDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingUserData {\n");
    
    sb.append("    patientFirstName: ").append(toIndentedString(patientFirstName)).append("\n");
    sb.append("    patientLastName: ").append(toIndentedString(patientLastName)).append("\n");
    sb.append("    patientContactNumber: ").append(toIndentedString(patientContactNumber)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    patientEmailId: ").append(toIndentedString(patientEmailId)).append("\n");
    sb.append("    patientLocationDetails: ").append(toIndentedString(patientLocationDetails)).append("\n");
    sb.append("    patientIdentificationDetail: ").append(toIndentedString(patientIdentificationDetail)).append("\n");
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

