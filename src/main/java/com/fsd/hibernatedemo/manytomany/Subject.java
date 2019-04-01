package com.fsd.hibernatedemo.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject1")
public class Subject implements Serializable{
	@Id	
	@GeneratedValue
	private int subject_id;
	private String subtitle;
	private int duration_in_hours;
	
	
	@ManyToMany(mappedBy="subjects", cascade=CascadeType.ALL)	
	private Set<Book1> books = new HashSet<Book1>();

	
	
	public Set<Book1> getBooks() {
		return books;
	}
	public void setBooks(Set<Book1> books) {
		this.books = books;
	}
	//private int book_id;
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getDuration_in_hours() {
		return duration_in_hours;
	}
	public void setDuration_in_hours(int duration_in_hours) {
		this.duration_in_hours = duration_in_hours;
	}
//	public int getBook_id() {
//		return book_id;
//	}
//	public void setBook_id(int book_id) {
//		this.book_id = book_id;
//	}
//	@Override
//	public String toString() {
//		return "Subject [subject_id=" + subject_id + ", subtitle=" + subtitle + ", duration_in_hours="
//				+ duration_in_hours + ", book_id=" + book_id + "]";
//	}
//	
	

}
