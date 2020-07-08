package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	private int content_rate;
	
	private int platform_rate;
	
	private String add_remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContent_rate() {
		return content_rate;
	}

	public void setContent_rate(int content_rate) {
		this.content_rate = content_rate;
	}

	public int getPlatform_rate() {
		return platform_rate;
	}

	public void setPlatform_rate(int platform_rate) {
		this.platform_rate = platform_rate;
	}

	public String getAdd_remarks() {
		return add_remarks;
	}

	public void setAdd_remarks(String add_remarks) {
		this.add_remarks = add_remarks;
	}

	public Feedback() {
		// TODO Auto-generated constructor stub
	}
}
