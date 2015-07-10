package com.karl.countycars.controller;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;

import com.karl.countycars.model.User;
import com.karl.countycars.util.HibernateUtil;

public class UserManager extends HibernateUtil {
    
    public boolean login(String userName) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	User user = (User) session.get(User.class, userName);
	HttpSession sess = ServletActionContext.getRequest().getSession();
	sess.setAttribute("county", user.getCounty());
	return (null != user);
    }
}