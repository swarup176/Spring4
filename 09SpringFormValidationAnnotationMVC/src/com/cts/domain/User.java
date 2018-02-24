package com.cts.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User  implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private String gender;
	private String country;
	
	private String aboutYou;
	private String[] community;
	
	private Boolean mailingList;
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAboutYou() {
		return aboutYou;
	}
	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}
	public String[] getCommunity() {
		return community;
	}
	public void setCommunity(String[] community) {
		this.community = community;
	}
	public Boolean getMailingList() {
		return mailingList;
	}
	public void setMailingList(Boolean mailingList) {
		this.mailingList = mailingList;
	}
	
	

}
