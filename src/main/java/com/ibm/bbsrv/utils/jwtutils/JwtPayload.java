package com.ibm.bbsrv.utils.jwtutils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtPayload { public String sub;
public List<Role> role;
public String cityName;
public String hospitalId;
public String pinCode;
public String hospitalBranchId;
public int exp;
public int iat;



public JwtPayload(String sub, List<Role> role, String cityName, String hospitalId, String pinCode,
		String hospitalBranchId, int exp, int iat) {
	super();
	this.sub = sub;
	this.role = role;
	this.cityName = cityName;
	this.hospitalId = hospitalId;
	this.pinCode = pinCode;
	this.hospitalBranchId = hospitalBranchId;
	this.exp = exp;
	this.iat = iat;
}

public JwtPayload() {
	super();
}



public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
public List<Role> getRole() {
	return role;
}
public void setRole(List<Role> role) {
	this.role = role;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getHospitalId() {
	return hospitalId;
}
public void setHospitalId(String hospitalId) {
	this.hospitalId = hospitalId;
}
public String getPinCode() {
	return pinCode;
}
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}
public String getHospitalBranchId() {
	return hospitalBranchId;
}
public void setHospitalBranchId(String hospitalBranchId) {
	this.hospitalBranchId = hospitalBranchId;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}
public int getIat() {
	return iat;
}
public void setIat(int iat) {
	this.iat = iat;
}
@Override
public String toString() {
	return "JwtPayload [sub=" + sub + ", role=" + role + ", cityName=" + cityName + ", hospitalId=" + hospitalId
			+ ", pinCode=" + pinCode + ", hospitalBranchId=" + hospitalBranchId + ", exp=" + exp + ", iat=" + iat + "]";
}


}
