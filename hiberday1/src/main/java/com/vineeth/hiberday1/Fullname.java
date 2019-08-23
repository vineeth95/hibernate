package com.vineeth.hiberday1;

import javax.persistence.Embeddable;

@Embeddable // used for storing multiple values using multiple fields at backend
public class Fullname {

	private String fname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Fullname [fname=" + fname + ", lname=" + lname + "]";
	}
	
	
}
