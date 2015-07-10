package com.karl.countycars.view;

import java.util.List;


import com.karl.countycars.controller.ResidentManager;
import com.karl.countycars.model.Resident;
import com.opensymphony.xwork2.ActionSupport;

public class ResidentAction extends ActionSupport {

    private static final long serialVersionUID = 361456251456L;
    private Resident resident;
    private List<Resident> residentList;
    private Long residentId;

    private ResidentManager linkController;

    public ResidentAction() {
	linkController = new ResidentManager();
    }

    public String execute() {
	this.residentList = linkController.list();
	return SUCCESS;
    }
    
    public String add() {
	try {
		linkController.add(getResident());
	} catch (Exception e) {
		e.printStackTrace();
	}
	this.residentList = linkController.list();
	return SUCCESS;
    }

    public String delete() {
	linkController.delete(getResidentId());
	return SUCCESS;
    }

    public Resident getResident() {
	return resident;
    }

    public List<Resident> getResidentList() {
	return residentList;
    }

    public void setResident(Resident resident) {
	this.resident = resident;
    }

    public void setResidentList(List<Resident> residentList) {
	this.residentList = residentList;
    }

    public Long getResidentId() {
	return residentId;
    }

    public void setResidentId(Long residentId) {
	this.residentId = residentId;
    }
}
