package com.simplilearn.maven_hibernate;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.Table;

public class UpdateDelete {

	Session theSession;

	SessionFactory theFactory;
	
	Scanner theScanner;

	public UpdateDelete() {
		
		theScanner = new Scanner(System.in);
		
//      Get a Reference to the SessionFactory
		SessionFactory theFactory = new Configuration()
				.configure("hibernate-config.xml")
				.addAnnotatedClass(Learners.class)
				.buildSessionFactory();

//   	Get a reference to the Session
		theSession = theFactory.getCurrentSession();

		try {
			theSession.beginTransaction();
		} finally {
//   		theFactory.close();
		}
	}

	public static void main(String[] args) {
		
		UpdateDelete ref = new UpdateDelete();
		
		System.out.println("Please enter the id : ");
		
		int learnerId = ref.theScanner.nextInt();
		
//		ref.deleteLearnerDetailsById(learnerId);
		
//		ref.deleteLearnerUsingHql(learnerId);
		
		
		
		ref.updateLearnerDetailsById(learnerId);
		
	}

//	This method when called, tries to update a Learner
	void updateLearnerDetailsById(int learnerId) {
		this.theScanner.nextLine();

		Learners theLearner = theSession.get(Learners.class, learnerId);

		System.out.println("Learner with id - " + learnerId + " :" + theLearner);
		
		System.out.println("Please enter the new name");
		
		String learnerNameToUpdate = theScanner.nextLine();
		
//		Update Learner's name
		
		theLearner.setLearnerFName(learnerNameToUpdate);
		
//		Commit the Transaction
		theSession.getTransaction().commit();
		
		System.out.println("\n\n After updating, learner details are : \n" + theLearner);

//		
	}
	
	
//	Delete Learner
	void deleteLearnerDetailsById(int learnerId) {
		Learners theLearner = theSession.get(Learners.class, learnerId);
		
//		Delete the Learner
		theSession.delete(theLearner);
		
//		Commit the Transaction
		theSession.getTransaction().commit();
	}
	
//Delete Learner by using HQL
	void deleteLearnerUsingHql(int learnerId) {
		int result = theSession.createQuery("delete from Learners where learnerId = " + learnerId).executeUpdate();
		
		theSession.getTransaction().commit();
	
		if(result > 0)
			System.out.println("Deleted from the Table");
		else
			System.out.println("Can't delete...");
	}

}
