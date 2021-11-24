package com.Exercice.Hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



import com.Exercice.model.Client;

public class hibernateUtils {
	
	private static final SessionFactory sessionFactory;
	private static  ServiceRegistry reg;
	
	static {
		
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			configuration.addAnnotatedClass(Client.class);
			
			reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(reg);
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
