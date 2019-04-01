package com.fsd.hibernatedemo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class OneToOneClient 
{
    public static void main(String[] args)
    {
    	System.out.println("starting..");
    	Book1 book = new Book1();    	
    	book.setPrice(100);
    	book.setTitle("Java Programming");
    	book.setVolume(3);
    	book.setPublishedDate(new Date());
    	//book.setSubject(subject)
    	
    	Subject subject = new Subject();
    	subject.setSubject_id(5001);
    	subject.setDuration_in_hours(6);
    	subject.setSubtitle("Computers2");    
    	
    	subject.setBook(book);
    	book.setSubject(subject);
    	insertBook(book);
    	insertSubject(subject);
    	updatetBook(book);
    }
	
//	public static void main(String[] args) {
//		System.out.println("testing");
//	}
    
    public static void insertBook(Book1 book) {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.save(book);
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    public static void insertSubject(Subject subject) {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.save(subject);
    	session.getTransaction().commit();
    	session.close();
    	
    }
	
    
    public static void updatetBook(Book1 book) {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.update(book);
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    public static void deleteBook(Book1 book) {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.delete(book);
    	session.getTransaction().commit();
    	session.close();
    	
    }
}
