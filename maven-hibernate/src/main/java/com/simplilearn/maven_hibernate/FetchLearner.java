package com.simplilearn.maven_hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchLearner {

	public static void main(String[] args) {
//      Get a Reference to the SessionFactory
   	SessionFactory theFactory = new Configuration()
   								.configure("hibernate-config.xml")
   								.addAnnotatedClass(Learners.class)
   								.buildSessionFactory();
   	
   	
//   	Get a reference to the Session
   	Session theSession =theFactory.getCurrentSession();
   	
   	try {
//   		Create a Learner object
//   		Learners theLearner = new Learners("Mohsin", "USA");
   		
//   		Start the transaction
   		theSession.beginTransaction();
   		
//   		Save the learner object
//   		theSession.save(theLearner);
   		
//   		System.out.println("Learner Id: " + theLearner.getLearnerId());
   		
   		System.out.println("Please enter the id: ");
   		
   		Scanner theScanner = new Scanner(System.in);
   		
   		int learnerId = theScanner.nextInt();
   		
   		Learners readLearner = theSession.get(Learners.class, learnerId);
   		
   		System.out.println(readLearner);
   		
//   		Commit the Transaction
   		theSession.getTransaction().commit();
   		
   	}finally {
   		theFactory.close();
	}

}
}
