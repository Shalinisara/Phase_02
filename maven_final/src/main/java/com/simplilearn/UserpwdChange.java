package com.simplilearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserpwdChange {

	Session theSession;

	SessionFactory theFactory;	

	public UserpwdChange() {
		
//      Get a Reference to the SessionFactory
		SessionFactory theFactory = new Configuration()
				.configure("hibernate-config.xml")
				.addAnnotatedClass(Userinfo.class)
				.buildSessionFactory();

//   	Get a reference to the Session
		theSession = theFactory.getCurrentSession();

		try {
			theSession.beginTransaction();
		} finally {
//   		theFactory.close();
		}
	}

//	This method when called, tries to update a Learner
	void changePass(String userid, String userpwd) {
		
		System.out.println("user id shalini passed to method is "+userid);
		Userinfo user = new Userinfo();
		user.setUserid(userid);
		user.setUserpwd(userpwd);
		theSession.save(user);
		theSession.getTransaction().commit();
		System.out.println("record successfully committed");
				
	}
	
	}
