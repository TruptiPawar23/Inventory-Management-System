package com.montran.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.montran.model.User;

public class UserDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	//save a user
	public static void saveUser(User user) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	//authenticate user
	public boolean validate(String username, String password) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String query = "FROM User where username=:user";
		User user = (User) session.createQuery(query).setParameter("user", username).uniqueResult();
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		tx.commit();
		return false;
	}
}