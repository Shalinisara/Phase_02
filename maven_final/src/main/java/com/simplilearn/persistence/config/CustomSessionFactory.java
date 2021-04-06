package com.simplilearn.persistence.config;

import com.simplilearn.persistence.entity.Flight;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomSessionFactory {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Flight.class)
                .buildSessionFactory();
    }

}
