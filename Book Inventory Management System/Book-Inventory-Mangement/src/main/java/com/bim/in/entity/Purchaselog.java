package com.bim.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaselog")
public class Purchaselog {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User UserID;

    @ManyToOne
    @JoinColumn(name = "InventoryID", referencedColumnName = "InventoryID", nullable = false)

    private Inventory InventoryID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserID() {
        return UserID;
    }

    public void setUserID(User userID) {
        this.UserID = userID;
    }

    public Inventory getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(Inventory inventoryID) {
        InventoryID = inventoryID;
    }

    public Purchaselog() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Purchaselog(int id, User userID, Inventory inventoryID) {
        super();
        this.id = id;
        this.UserID = userID;
        InventoryID = inventoryID;
    }

}