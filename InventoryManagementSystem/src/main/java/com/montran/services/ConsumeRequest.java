package com.montran.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.montran.model.*;


public class ConsumeRequest {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public  static void save(ConsumptionRequest rq) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(rq);
		tx.commit();
	}
}