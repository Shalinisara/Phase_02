package com.simplilearn;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetchflights {
	
    Session theSession;
    SessionFactory theFactory; 
	
	public Fetchflights() {
		
//      Get a Reference to the SessionFactory
   	SessionFactory theFactory = new Configuration()
   								.configure("hibernate-config.xml")
   								.addAnnotatedClass(flights.class)
   								.buildSessionFactory();
   	
   	
//   	Get a reference to the Session
   	theSession =theFactory.getCurrentSession();
   	
   	try {
   		theSession.beginTransaction();
   	}
   	finally {
//   		theFactory.close();
   	}
	}


//		 Using OR with HQL
		 List<flights> getflightbyplace(String source, String destination){
			 
			 return theSession.createQuery("from flights l where l.source = '" + source + "' AND l.destination = '" + destination + "'").getResultList();
			 
}
}
