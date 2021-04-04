package com.simplilearn.maven_hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchOperationsUsingHQL {
	
    Session theSession;
    SessionFactory theFactory; 
	
	public FetchOperationsUsingHQL() {
		
//      Get a Reference to the SessionFactory
   	SessionFactory theFactory = new Configuration()
   								.configure("hibernate-config.xml")
   								.addAnnotatedClass(Learners.class)
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

	

	public static void main(String[] args) {
		
		 // List<Learners> theLearners = new FetchOperationsUsingHQL().getAllLearners();
		 
		System.out.println("Enter the name and id of learner: ");
		
		Scanner theScanner =  new Scanner(System.in);
		
		String learnerFname = theScanner.nextLine();
		
		int id = theScanner.nextInt();
		
		//System.out.println("Enter the address to search: ");
		
		//String addressToSearchFor = new Scanner(System.in).nextLine();
		//List<Learners> theLearners =  new FetchOperationsUsingHQL().getLearnersByAddress(addressToSearchFor);
		//List<Learners> theLearners =  new FetchOperationsUsingHQL().getLearnersByAddressLike(addressToSearchFor);
		List<Learners> theLearners =  new FetchOperationsUsingHQL().getLearnersByIdOrName(id, learnerFname);
		for(Learners tempLearners : theLearners) { System.out.println(tempLearners);
		  }
	}

//	This method when called, gets all learners from the table:learners
	List<Learners> getAllLearners(){
		return theSession.createQuery("from Learners").getResultList();
	}
	
//	This method when called, returns a Learners by address
	 List<Learners> getLearnersByAddress(String address) {
		return theSession.createQuery("from Learners l where l.LearnerAddr = '" + address + "'").getResultList();
	}
	 
	// This method returns all those Learners whose address ends with USA
		 List<Learners> getLearnersByAddressLike(String addressToSearchFor){
			 return theSession.createQuery("from Learners l where l.LearnerAddr LIKE '%" + addressToSearchFor + "'").getResultList();
		 }
		 
//		 Using OR with HQL
		 List<Learners> getLearnersByIdOrName(int id, String learnerFName){
			 return theSession.createQuery("from Learners l where l.LearnerId = '" + id + "' OR l.LearnerFName = '" + learnerFName + "'").getResultList();
		 }
}
