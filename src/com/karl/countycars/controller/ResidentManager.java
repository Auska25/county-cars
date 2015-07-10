package com.karl.countycars.controller;

import java.util.List;

import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.karl.countycars.model.Resident;
import com.karl.countycars.util.County;
import com.karl.countycars.util.HibernateUtil;

public class ResidentManager extends HibernateUtil {

    public Resident add(Resident resident) {
	HttpSession httpSession = ServletActionContext.getRequest().getSession();
	County county = (County) httpSession.getAttribute("county");
	resident.setCounty(county);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	session.save(resident);
	session.getTransaction().commit();
	return resident;
    }

    public Resident delete(Long residentId) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	Resident resident = (Resident) session.load(Resident.class, residentId);
	if (null != resident) {
	    session.delete(resident);
	}
	session.getTransaction().commit();
	return resident;
    }

    public List<Resident> list() {
	
	HttpSession httpSession = ServletActionContext.getRequest().getSession();
	County county = (County) httpSession.getAttribute("county");
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List<Resident> residents = null;
	try {
	    Query query = session.createQuery("from Resident where county = :county");
	    query.setParameter("county", county);
	    residents = (List<Resident>) query.list();
		session.getTransaction().commit();
	} catch (HibernateException e) {
	    e.printStackTrace();
	    session.getTransaction().rollback();
	}
	return residents;
    }
    
    public List<Resident> list(County county) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List<Resident> residents = null;
	try {
	    Query query = session.createQuery("from Resident where county = :county");
	    query.setParameter("county", county);
	    List list =  query.list();
	    System.out.println(list);
	    residents = (List<Resident>) list;
	    session.getTransaction().commit();
	} catch (HibernateException e) {
	    e.printStackTrace();
	    session.getTransaction().rollback();
	}
	return residents;
    }
    
    public Resident get(Long residentId) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	Resident resident = (Resident) session.load(Resident.class, residentId);
	return resident;
    }
}
