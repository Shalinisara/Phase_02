package com.simplilearn.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_detail",schema = "booking")
public class UserDetail {
	
	

	public UserDetail() {
		super();
	}

	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name="userid")
	private String userid;

	@Column(name="userpwd")
	private String userpwd;

	public UserDetail(String userid, String userpwd) {
		this.id = id;
		this.userid = userid;
		this.userpwd = userpwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
