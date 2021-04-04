package com.simplilearn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class Userinfo {
	
	public Userinfo()
	{
		
	}
	

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Userinfo(int userno, String userid, String userpwd) {
		this.userno = userno;
		this.userid = userid;
		this.userpwd = userpwd;
	}

	@Column(name="userno") //Tells Hibernate to map this property to the column in table
	@GeneratedValue(strategy = GenerationType.IDENTITY) //For Auto-Increment columns
	@Id //Tells Hibernate this is our primary key in the table
	int userno;
	
	@Column(name="userid")
	String userid;
	
	@Column(name="userpwd")
	String userpwd;
	
	
	
}
