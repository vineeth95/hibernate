package com.vineeth.hiberday1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class useraccounts //pojo or bean

{
	@Id
	private int userid;
	private Fullname username;  //Instead of String we are using type as class - "Fullname" which has definitions
	private String password;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public Fullname getUsername() {
		return username;
	}
	public void setUsername(Fullname username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "useraccounts [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
