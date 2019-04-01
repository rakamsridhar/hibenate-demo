package com.fsd.hibernatedemo.manytomany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class ManytoManyClient 
{
    public static void main(String[] args)
    {
    	System.out.println("starting..");
    	Book1 book = new Book1();    	
    	book.setPrice(100);
    	book.setTitle("Java Programming one");
    	book.setVolume(1);
    	book.setPublishedDate(new Date());
    	
    	Book1 book2 = new Book1();    	
    	book2.setPrice(200);
    	book2.setTitle("Java Programming two");
    	book2.setVolume(2);
    	book2.setPublishedDate(new Date());
    	
    	Book1 book3 = new Book1();    	
    	book3.setPrice(300);
    	book3.setTitle("Java Programming three");
    	book3.setVolume(3);
    	book3.setPublishedDate(new Date());

    	Set<Subject> subjects = new HashSet<Subject>();
    	Subject subject = new Subject();
    	subject.setSubject_id(5001);
    	subject.setDuration_in_hours(6);
    	subject.setSubtitle("Computers6");
    	subjects.add(subject);
    	
//    	Subject subject1 = new Subject();
//    	subject1.setSubject_id(5002);
//    	subject1.setDuration_in_hours(3);
//    	subject1.setSubtitle("Computers3");
//    	subjects.add(subject1);
    	
    	//subject.setBook(book);
    	book.setSubjects(subjects);
    	book2.setSubjects(subjects);
    	book3.setSubjects(subjects);
    	
    	Set<Book1> books = new HashSet<Book1>();
    	books.add(book);
    	books.add(book2);
    	books.add(book3);
    	subject.setBooks(books);
    	
    	//insertBook(book);
    	insertSubject(subject);
    	//updatetBook(book);
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
}
