package com.karl.countycars.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.karl.countycars.model.Car;
import com.karl.countycars.util.HibernateUtil;

public class CarManager extends HibernateUtil {

    public Car add(Car car) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	session.save(car);
	session.getTransaction().commit();
	return car;
    }

    public Car delete(String licencePlate) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	Car car = (Car) session.load(Car.class, licencePlate);
	if (null != car) {
	    session.delete(car);
	}
	session.getTransaction().commit();
	return car;
    }
    
    public List<Car> list(int residentId) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List<Car> cars = null;
	try {
	    Query query = session.createQuery("from Car where resident_residentId = :residentId");
	    query.setParameter("residentId", (long)residentId);
	    cars = (List<Car>) query.list();
	    session.getTransaction().commit();
	} catch (HibernateException e) {
	    e.printStackTrace();
	    session.getTransaction().rollback();
	}
	return cars;
    }
}
