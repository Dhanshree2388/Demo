package com.learning.web.entity;
import java.sql.*;

public class Register {
	
	private String name;
	private String eid;
	private String dob;
	//private String uname;
	//private String pwd;
	private String cpwd;
	private String mobile;
	//private String location;
	private String college;
	private String qualification;
	//private String id;
	private String city;
	private String state;
	private String country;
	
	//public String getId() {
		//return id;
	//}
	//public void setId(String id) {
	//	this.id = id;
	//}
	public String getDob() {
		return dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	/*public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}*/
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}

	/*public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}*/
	/*public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}*/
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
