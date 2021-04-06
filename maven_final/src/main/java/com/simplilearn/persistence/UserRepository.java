package com.simplilearn.persistence;

import com.simplilearn.persistence.config.CustomSessionFactory;
import com.simplilearn.persistence.entity.UserDetail;
import org.hibernate.Session;

public class UserRepository {

	CustomSessionFactory customSessionFactory;

	public UserRepository() {
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
