
package com.bim.in.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@Column(name = "InventoryID")
	private int inventoryid;
	@Column(name = "purchased")
	private int Purchased;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Ranks")
	@JsonIgnoreProperties({ "price", "description", "full_description", "title", "discription" })
	private BookCondition ranks;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ISBN")
	private Book ISBN;

	public BookCondition getRanks() {
		return ranks;
	}

	public void setRanks(BookCondition ranks) {
		this.ranks = ranks;
	}

	public Book getISBN() {
		return ISBN;
	}

	public void setISBN(Book iSBN) {
		ISBN = iSBN;
	}

	public int getInventoryID() {
		return inventoryid;
	}

	public void setInventoryID(int InventoryID) {
		this.inventoryid = InventoryID;
	}

	public int getPurchased() {
		return Purchased;
	}

	public void setPurchased(int purchased) {
		Purchased = purchased;
	}

	public Inventory(int InventoryID, int purchased) {
		super();
		this.inventoryid = InventoryID;
		Purchased = purchased;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
