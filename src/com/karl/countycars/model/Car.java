package com.karl.countycars.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;

import com.karl.countycars.util.Color;

@Entity
@Table(name = "Cars")
public class Car implements Serializable {
    private static final long serialVersionUID = 3216541654231456L;

    private String licencePlate;
    private String make;
    private String model;
    private Color color;
    private Resident resident;

    @Id
    @Column(name = "licencePlate")
    public String getLicencePlate() {
	return licencePlate;
    }

    @Column(name = "make")
    public String getMake() {
	return make;
    }

    @Column(name = "model")
    public String getModel() {
	return model;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    public Color getColor() {
	return color;
    }

    @ManyToOne
    @NotEmpty
    public Resident getResident() {
	return resident;
    }

    public void setLicencePlate(String licencePlate) {
	this.licencePlate = licencePlate;
    }

    public void setMake(String make) {
	this.make = make;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public void setColor(Color color) {
	this.color = color;
    }

    public void setResident(Resident resident) {
	this.resident = resident;
    }
}
