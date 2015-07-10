package com.karl.countycars.view;


import com.karl.countycars.controller.UserManager;
import com.karl.countycars.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 361456251456L;
    private User user;
    private String userName;

    private UserManager linkController;

    public UserAction() {
	linkController = new UserManager();
    }

    public String execute() {
	return SUCCESS;
    }
    
    public String login() {
	String ret ="failure";
	if(linkController.login(getUser().getUserName()))
	{
	    ret = SUCCESS;
	}
	return ret;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }
}
