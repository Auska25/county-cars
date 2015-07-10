package com.karl.countycars.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.karl.countycars.util.County;

@Entity
@Table(name = "Residents")
public class Resident implements Serializable {
    private static final long serialVersionUID = 322316546165L;

    private Long residentId;
    private String firstName;
    private String lastName;
    private County county;

    @Id
    @GeneratedValue
    @Column(name = "residentId")
    public Long getResidentId() {
	return residentId;
    }

    @Column(name = "firstName")
    public String getFirstName() {
	return firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
	return lastName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "county")
    public County getCounty() {
	return county;
    }

    public void setResidentId(Long residentId) {
	this.residentId = residentId;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setCounty(County county) {
	this.county = county;
    }
}
