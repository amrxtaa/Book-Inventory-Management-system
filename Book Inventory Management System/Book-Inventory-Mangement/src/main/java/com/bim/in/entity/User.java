//package com.bim.in.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.MapsId;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//	@Id
//	@Column(name = "UserID")
//	private int userid;
//
//	@Column(name = "last_name")
//	private String lastName;
//
//	@Column(name = "first_name")
//	private String firstName;
//
//	@Column(name = "phone_number")
//	private String phoneNumber;
//
//	@Column(name = "user_name")
//	private String userName;
//
//	@Column(name = "Password")
//	private String password;
//
//	@OneToOne
//	@JoinColumn(name = "role_number")
//	@JsonIgnoreProperties({ "permRole" })
//	private PermRole permrole;
//
//	public PermRole getPremrole() {
//		return permrole;
//	}
//
//	public void setPremrole(PermRole premrole) {
//		this.permrole = premrole;
//	}
//
//	public int getUserID() {
//		return userid;
//	}
//
//	public void setUserID(int userID) {
//		this.userid = userID;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(int userID, String lastName, String firstName, String phoneNumber, String userName, String password,
//				PermRole premrole) {
//		super();
//		this.userid = userID;
//		this.lastName = lastName;
//		this.firstName = firstName;
//		this.phoneNumber = phoneNumber;
//		this.userName = userName;
//		this.password = password;
//		this.permrole = premrole;
//	}
//
//}