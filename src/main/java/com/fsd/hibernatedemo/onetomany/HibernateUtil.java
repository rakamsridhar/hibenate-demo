package com.fsd.hibernatedemo.onetomany;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;




public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		//StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(
		    configuration.getProperties()).build();

		factory= configuration.buildSessionFactory(sr);		
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
		
	}
	
	public static void shutdown() {
		factory.close();
	}

}
