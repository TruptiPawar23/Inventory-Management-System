package com.montran.services;


import java.util.*;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.montran.model.Product;

public class ProductDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public static void saveProduct(Product product) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
	}
	public static List<Product> getAllProducts() {
		Session session = factory.openSession();
		String hql = "From Product";
		Query<Product> query = session.createQuery(hql, Product.class);
		List<Product> products = query.list();
		return products;
	}
	public static Product getProductByID(int id) {
		Session session = factory.openSession();
		Product p = session.get(Product.class, id);
		return p;
	}
	public static void updateProduct(Product p) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "Update Product set product_name =: name, quantity =: quan, price =: pr, man_date =: md, exp_date =: ed, ctg =: c where product_id =: id";
		Query query = session.createQuery(hql);
		query.setParameter("name", p.getProduct_name());
		query.setParameter("quan", p.getQuantity());
		query.setParameter("pr", p.getPrice());
		query.setParameter("md", p.getMan_date());
		query.setParameter("ed", p.getExp_date());
		query.setParameter("c", p.getCtg());
		query.setParameter("id", p.getProduct_id());
		query.executeUpdate();
		tx.commit();
	}
	public static void delete(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Product where product_id =: pid";
		Query query = session.createQuery(hql);
		query.setParameter("pid", id);
		query.executeUpdate();
		tx.commit();
	}
	public static List<Long> getCount(int ctg_id) {
		List<Long> count;
		Session session = factory.openSession();
		String hql ="select count(*) from Product where ctg = "+ ctg_id ;
		Query query = session.createQuery(hql);
		count = query.getResultList();
		return count;
	}

}