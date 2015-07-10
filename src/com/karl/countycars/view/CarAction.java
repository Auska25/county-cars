package com.karl.countycars.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.karl.countycars.controller.CarManager;
import com.karl.countycars.controller.ResidentManager;
import com.karl.countycars.model.Car;
import com.karl.countycars.model.Resident;
import com.karl.countycars.util.County;
import com.opensymphony.xwork2.ActionSupport;

public class CarAction extends ActionSupport {

    private static final long serialVersionUID = 361456251456L;
    private Car car;
    private List<Car> carList;
    private String licencePlate;
    private int residentId;
    private Resident resident;

    private CarManager linkController;
    private ResidentManager residentManager;

    public CarAction() {
	linkController = new CarManager();
    }

    public String execute() {
	this.carList = linkController.list(getResidentId());
	HttpSession sess = ServletActionContext.getRequest().getSession();
	sess.setAttribute("residentId", getResidentId());
	return SUCCESS;
    }
    
    public String add() {
	HttpSession httpSession = ServletActionContext.getRequest().getSession();
	setResidentId((int)httpSession.getAttribute("residentId"));
	residentManager = new ResidentManager();
	resident = residentManager.get((long) residentId);
	if(null != resident)
	{
	    getCar().setResident(resident);
	}
	try {
		linkController.add(getCar());
	} catch (Exception e) {
		e.printStackTrace();
	}
	this.carList = linkController.list(residentId);
	
	return SUCCESS;
    }

    public String delete() {
	linkController.delete(getLicencePlate());
	return SUCCESS;
    }

    public Car getCar() {
	return car;
    }

    public List<Car> getCarList() {
	return carList;
    }

    public void setCar(Car car) {
	this.car = car;
    }

    public void setCarList(List<Car> carList) {
	this.carList = carList;
    }

    public String getLicencePlate() {
	return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
	this.licencePlate = licencePlate;
    }
    
    public int getResidentId() {
	return residentId;
    }

    
    public void setResidentId(int residentId) {
	this.residentId = residentId;
    }
    
    public Resident getResident() {
	return resident;
    }
    
    public void setResident(Resident resident) {
	this.resident = resident;
    }
}
