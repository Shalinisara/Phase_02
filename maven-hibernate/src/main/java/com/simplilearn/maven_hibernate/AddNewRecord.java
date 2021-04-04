package com.simplilearn.maven_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddNewRecord 
{
    public static void main( String[] args )
    {
//       Get a Reference to the SessionFactory
    	SessionFactory theFactory = new Configuration()
    								.configure("hibernate-config.xml")
    								.addAnnotatedClass(Learners.class)
    								.addAnnotatedClass(Mobile.class)
    								.buildSessionFactory();
    	
    	
//    	Get a reference to the Session
    	Session theSession =theFactory.getCurrentSession();
    	
    	try {
//    		Create a Learner Object
    		Learners theLearner = new Learners("Jai", "Pandian","St louis, USA");
    		//Learners theLearner = new Learners()
    		
//    		Start the transaction
    		theSession.beginTransaction();
    		
    		//Skill theskill = new Skill("JAVA", "5.0");
    		
			
			 // Create new skills for this learner 
				/*
				 * Skill firstSkill = new Skill("Clarity", "4.0"); Skill secondSkill = new
				 * Skill("QualityCenter","4.5"); Skill thirdSkill = new Skill("ALM", "5.0");
				 * Skill fourthSkill =new Skill("Outlook", "4.5");
				 */
			  
			 // Set the skills into a collection for the learner
				/*
				 * theLearner.getListOfSkills().add(firstSkill);
				 * theLearner.getListOfSkills().add(secondSkill);
				 * theLearner.getListOfSkills().add(thirdSkill);
				 * theLearner.getListOfSkills().add(fourthSkill);
				 */
			 
    		
//    		Set the Skill for this Learner
//    		theLearner.setSkill(theskill);
    		
    		Mobile theMobile = new Mobile("Iphone","Apple");
    		
//    		Set the mobile for this Learner
    		theLearner.setTheMobile(theMobile);
    		
    		theSession.save(theMobile);
//    		Save the new object
    		theSession.save(theLearner);
    		
//    		Commit the Transaction
    		theSession.getTransaction().commit();
    		
    		
    	}finally {
//    		Close the factory
    		theFactory.close();
    	}
    }
}

