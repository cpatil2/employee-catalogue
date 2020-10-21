package com.demo.employeecatalogue.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5640324430356127420L;

	private int userId;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate dob;
	private String mobile;
	private String email;
	
	public UserDetailsDTO() {
		
	}

	public UserDetailsDTO(int userId, String name, LocalDate dob, String mobile, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "UserDetailsDTO [userId=" + userId + ", name=" + name + ", dob=" + dob + ", mobile=" + mobile
				+ ", email=" + email + "]";
	}

}
