package com.montran.services;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.montran.model.*;
public class AcceptRejectDisplayDao {
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static List<ConsumptionRequest> display(){
		
		Session session = factory.openSession();
		Query<ConsumptionRequest> query = session.createQuery("FROM ConsumptionRequest where status=:req",ConsumptionRequest.class).setParameter("req",ConsumptionRequest.RequestStatus.PENDING);
		List<ConsumptionRequest> l=query.list();
		return l;

		
	}
}