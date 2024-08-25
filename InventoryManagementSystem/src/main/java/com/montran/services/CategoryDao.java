package com.montran.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.montran.model.Category;



public class CategoryDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	public void saveCategory(Category ctg) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ctg);
		tx.commit();
	}
	public static List<Category> getCategory() {
		Session session = factory.openSession();
		String hql = "From Category";
		Query<Category> query = session.createQuery(hql, Category.class);
		List<Category> ctg = query.list();
		return ctg;
	}
	public static Category getCategoryByID(int id) {
		Session session = factory.openSession();
		Category c = session.get(Category.class, id);
		return c;
	}
	public static Category getCategoryByName(String name) {
		Session session = factory.openSession();
		String hql = "From Category c where c.category_name =: name";
		Query query = session.createQuery(hql, Category.class);
		query.setParameter("name", name);
		Category ctg = (Category) query.uniqueResult();
		return ctg;
	}
	public static void updateCategory(Category ctg) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Category c set c.category_name =: name where c.category_id =: id";
		Query query = session.createQuery(hql);
		query.setParameter("name", ctg.getCategory_name());
		query.setParameter("id", ctg.getCategory_id());
		query.executeUpdate();
		tx.commit();
	}
	public static void deleteUpdate(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Category c where c.category_id =: cid";
		Query query = session.createQuery(hql);
		query.setParameter("cid", id);
		query.executeUpdate();
		tx.commit();
	}
}
