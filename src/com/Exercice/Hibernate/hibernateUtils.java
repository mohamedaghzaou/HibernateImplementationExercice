package com.Exercice.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Exercice.model.Client;
import com.Exercice.model.Product;

public class hibernateUtils {

	// SessionFactory create Session to connect to database
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry reg;

	static {

		// loads mappings and properties from the convention resource file
		// hibernate.cfg.xml
		Configuration configuration = new Configuration();
		configuration.configure();
		// in case the propeties file name different than hibernate.cfg.xml
		// configuration.configure("hibernate.cfg.xml");

		// configuration.addAnnotatedClass(Client.class);
		configuration.addAnnotatedClass(Product.class);

		reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(reg);

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

}
