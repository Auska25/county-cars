package com.karl.countycars.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.karl.countycars.util.County;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    private static final long serialVersionUID = 21365464165465L;
    
    private String userName;
    private County county;

    @Id
    @Column(name = "userName")
    public String getUserName() {
	return userName;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "county")
    public County getCounty() {
	return county;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public void setCounty(County county) {
	this.county = county;
    }
}




