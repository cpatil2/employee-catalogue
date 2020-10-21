package com.demo.employeecatalogue.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="user_details")
@Data
public class UserDetails {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	@Id
	private int userId;
	
	@Column(name="name")
	private String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="email	")
	private String email;
	
	
	
	
	public UserDetails() {
		super();
	}

	public UserDetails(String name, LocalDate dob, String mobile, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", dob=" + dob + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	
	
}
