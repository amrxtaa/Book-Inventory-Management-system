package com.bim.in.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	@Column(name="author_id")
	private int authorid;
	@Column(name="last_name")
	private String lastName;
	@Column(name="first_name")
	private String firstName;
	@Column
	private String photo;
	@OneToMany(mappedBy="author")
	@JsonIgnore
	private List<BookAuthor> bookauthor;

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int author_id) {
		this.authorid = author_id;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Author() {
		super();
	}

	public Author(int authorid, String last_name, String first_name, String photo) {
		super();
		this.authorid = authorid;
		this.lastName = last_name;
		this.firstName = first_name;
		this.photo = photo;
	}



}