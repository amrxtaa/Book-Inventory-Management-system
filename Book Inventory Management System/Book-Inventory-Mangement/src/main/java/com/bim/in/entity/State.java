//package com.bim.in.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "state")
//public class State {
//	@Id
//	@Column(name = "state_code")
//	private String state_code;
//	@Column(name = "StateName")
//	private String state_name;
//
//	public State() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public State(String state_code, String state_name) {
//		super();
//		this.state_code = state_code;
//		this.state_name = state_name;
//	}
//
//	public String getState_code() {
//		return state_code;
//	}
//
//	public void setState_code(String state_code) {
//		this.state_code = state_code;
//	}
//
//	public String getState_name() {
//		return state_name;
//	}
//
//	public void setState_name(String state_name) {
//		this.state_name = state_name;
//	}
//
//}