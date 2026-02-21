package com.bim.in.entity;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category
{
    @Id
    @Column(name="catid")
    private int catid;
    @Column (name="cat_description")
    private String cat_description;
    public int getCatid() {
        return catid;
    }
    public void setCatid(int catid) {
        this.catid = catid;
    }
    public String getCat_description() {
        return cat_description;
    }
    public void setCat_description(String cat_description) {

        this.cat_description = cat_description;

    }
}