package com.ibm.bbsrv.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ibm.bbsrv.model.Hospital;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookingResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-05T09:29:11.005Z")


public class BookingResponse   {
  @JsonProperty("bookingId")
  private String bookingId = null;

  @JsonProperty("bookingStatus")
  private String bookingStatus = null;

  @JsonProperty("waitingNumber")
  private String waitingNumber = null;

  @JsonProperty("Hospitals")
  @Valid
  private List<Hospital> hospitals = null;

  public BookingResponse bookingId(String bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * A booking id for the the booking
   * @return bookingId
  **/
  @ApiModelProperty(value = "A booking id for the the booking")


  public String getBookingId() {
    return bookingId;
  }

  public void setBookingId(String bookingId) {
    this.bookingId = bookingId;
  }

  public BookingResponse bookingStatus(String bookingStatus) {
    this.bookingStatus = bookingStatus;
    return this;
  }

  /**
   * Booking status (Confirmed, Pending)
   * @return bookingStatus
  **/
  @ApiModelProperty(value = "Booking status (Confirmed, Pending)")


  public String getBookingStatus() {
    return bookingStatus;
  }

  public void setBookingStatus(String bookingStatus) {
    this.bookingStatus = bookingStatus;
  }

  public BookingResponse waitingNumber(String waitingNumber) {
    this.waitingNumber = waitingNumber;
    return this;
  }

  /**
   * Waiting number of patient
   * @return waitingNumber
  **/
  @ApiModelProperty(value = "Waiting number of patient")


  public String getWaitingNumber() {
    return waitingNumber;
  }

  public void setWaitingNumber(String waitingNumber) {
    this.waitingNumber = waitingNumber;
  }

  public BookingResponse hospitals(List<Hospital> hospitals) {
    this.hospitals = hospitals;
    return this;
  }

  public BookingResponse addHospitalsItem(Hospital hospitalsItem) {
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
    BookingResponse bookingResponse = (BookingResponse) o;
    return Objects.equals(this.bookingId, bookingResponse.bookingId) &&
        Objects.equals(this.bookingStatus, bookingResponse.bookingStatus) &&
        Objects.equals(this.waitingNumber, bookingResponse.waitingNumber) &&
        Objects.equals(this.hospitals, bookingResponse.hospitals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, bookingStatus, waitingNumber, hospitals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingResponse {\n");
    
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    bookingStatus: ").append(toIndentedString(bookingStatus)).append("\n");
    sb.append("    waitingNumber: ").append(toIndentedString(waitingNumber)).append("\n");
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

