package com.ibm.bbsrv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasConfirmRequest {
	  @JsonProperty("bedId")
	  private String bedId = null;

	  @JsonProperty("status")
	  private String status = null;

	  @JsonProperty("bookingId")
	  private String bookingId = null;
	  

	@Override
	public String toString() {
		return "UpdateStatus [bedId=" + bedId + ", status=" + status + ", bookingId=" + bookingId + "]";
	}
	
	public BasConfirmRequest() {
			}
	
	public BasConfirmRequest(String bedId, String status, String bookingId) {
		super();
		this.bedId = bedId;
		this.status = status;
		this.bookingId = bookingId;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
}
