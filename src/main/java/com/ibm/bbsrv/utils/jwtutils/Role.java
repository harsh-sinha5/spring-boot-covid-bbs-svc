package com.ibm.bbsrv.utils.jwtutils;

public class Role {
	
	  public String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority + ", getAuthority()=" + getAuthority() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	  
	  
}
