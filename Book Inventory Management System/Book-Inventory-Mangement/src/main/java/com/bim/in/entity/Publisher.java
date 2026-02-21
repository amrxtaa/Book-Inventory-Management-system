//package com.bim.in.entity;
//
//import jakarta.persistence.*;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "publisher")
//public class Publisher {
//	@Id
//	@Column(name = "PublisherID")
//	private int PublisherID;
//	@Column(name = "Name")
//	private String Name;
//	@Column(name = "City")
//	private String City;
//	@ManyToOne
//	@JoinColumn(name = "state_code", referencedColumnName = "state_code")
//	private State state;
//
//	public State getState() {
//		return state;
//	}
//
//	public void setState(State state) {
//		this.state = state;
//	}
//
//	public int getPublisherID() {
//		return PublisherID;
//	}
//
//	public void setPublisherID(int publisherID) {
//		this.PublisherID = publisherID;
//	}
//
//	public String getName() {
//		return Name;
//	}
//
//	public void setName(String name) {
//		Name = name;
//	}
//
//	public String getCity() {
//		return City;
//	}
//
//	public void setCity(String city) {
//		City = city;
//	}
//
//	public Publisher(int pid, String name, String city) {
//		super();
//		pid = pid;
//		Name = name;
//		City = city;
//	}
//
//	public Publisher() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//}