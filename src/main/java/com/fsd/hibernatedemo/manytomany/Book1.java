package com.fsd.hibernatedemo.manytomany;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name="book1")
public class Book1 implements Serializable{
	@Id
	@GeneratedValue
	private int book_id;
	
	@Column(length=40)
	private String title;
	
	private double price;
	private int volume;
	
	@Temporal(TemporalType.DATE)
	private Date publishedDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="bookmapping",
			joinColumns=@JoinColumn(name="book_id"),
			inverseJoinColumns=@JoinColumn(name="subject_id")
			)
	private Set<Subject> subjects;
	
	
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {		
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishedDate=" + publishedDate + "]";
	}
	
	

}
