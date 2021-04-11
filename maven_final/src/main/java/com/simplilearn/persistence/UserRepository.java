package com.simplilearn.persistence;

import com.simplilearn.persistence.config.CustomSessionFactory;
import com.simplilearn.persistence.entity.UserDetail;
import org.hibernate.Session;

public class UserRepository {

	CustomSessionFactory customSessionFactory;

	public UserRepository() {
		this.customSessionFactory=new CustomSessionFactory();
	}

	public UserDetail getUserByUserId(String userId){
		Session session=this.customSessionFactory.getSessionFactory().openSession();
		System.out.println(String.format("Looking for userId=%s", userId));
		try{
			String query="FROM UserDetail where userid=:userId";
			return (UserDetail) session
					.createQuery(query)
					.setParameter("userId",userId)
					.getSingleResult();
		}
		finally {
			session.close();
		}
	}

	public void updateUser(UserDetail userDetail) {
		System.out.println("user id shalini passed to method is "+userDetail.getUserid());
		Session session=this.customSessionFactory.getSessionFactory().openSession();
		try{
			session.save(userDetail);
			
		}
		finally {
			session.close();
			
		}
		System.out.println("record successfully committed");
	}
	
	}
