package com.Exercice.Hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.Exercice.model.Client;

public class hibernateUtils {
	
	private static  SessionFactory sessionFactory;
	private static  org.hibernate.service.ServiceRegistry reg;
	
	static {
		try {
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			configuration.addAnnotatedClass(Client.class);
			
			reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(reg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
