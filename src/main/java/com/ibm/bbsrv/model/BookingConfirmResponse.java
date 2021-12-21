package com.ibm.bbsrv.model;

import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * BookingConfirmResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-04T10:00:04.233Z")


public class BookingConfirmResponse   {
  @JsonProperty("bookingId")
  private String bookingId = null;

  @JsonProperty("bookingStatus")
  private String bookingStatus = null;

  @JsonProperty("Hospital")
  private HospitalConfirm hospital = null;

  public BookingConfirmResponse bookingId(String bookingId) {
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

  public BookingConfirmResponse bookingStatus(String bookingStatus) {
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

  public BookingConfirmResponse hospital(HospitalConfirm hospital) {
    this.hospital = hospital;
    return this;
  }

  /**
   * Get hospital
   * @return hospital
  **/
  @ApiModelProperty(value = "")

  @Valid

  public HospitalConfirm getHospital() {
    return hospital;
  }

  public void setHospital(HospitalConfirm hospital) {
    this.hospital = hospital;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingConfirmResponse bookingConfirmResponse = (BookingConfirmResponse) o;
    return Objects.equals(this.bookingId, bookingConfirmResponse.bookingId) &&
        Objects.equals(this.bookingStatus, bookingConfirmResponse.bookingStatus) &&
        Objects.equals(this.hospital, bookingConfirmResponse.hospital);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, bookingStatus, hospital);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingConfirmResponse {\n");
    
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    bookingStatus: ").append(toIndentedString(bookingStatus)).append("\n");
    sb.append("    hospital: ").append(toIndentedString(hospital)).append("\n");
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

