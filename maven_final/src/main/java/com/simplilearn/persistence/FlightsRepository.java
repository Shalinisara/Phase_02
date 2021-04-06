package com.simplilearn.persistence;

import java.util.List;

import com.simplilearn.persistence.config.CustomSessionFactory;
import com.simplilearn.persistence.entity.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FlightsRepository {
	
    private CustomSessionFactory customSessionFactory;
	
	public FlightsRepository() {
		this.customSessionFactory=new CustomSessionFactory();
	}

	public List<Flight> searchFlightsBySourceAndDestination(String source, String destination){
		   Session session=customSessionFactory.getSessionFactory().openSession();
			try
			{
				String query="from Flights l where l.source=:source AND l.destination =:destination";
				return session
						.createQuery(query)
						.setParameter("source",source)
						.setParameter("destination",destination)
						.getResultList();
			}finally {
				session.close();
			}
	}

}
