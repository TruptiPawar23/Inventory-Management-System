package com.montran.services;

import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.montran.model.Admin;

public class AdminDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static boolean authenticate(String username, String password) {
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "FROM Admin where username=:user";
			Admin admin = (Admin) session.createQuery(query).setParameter("user", username).uniqueResult();
			if(admin != null && admin.getPassword().equals(password)) {
				return true;
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}