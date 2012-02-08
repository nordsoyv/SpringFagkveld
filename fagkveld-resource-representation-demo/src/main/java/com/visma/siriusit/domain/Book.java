package com.visma.siriusit.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "book")
public class Book {

	private int id; 
	
	private String title; 
	
	private String author;

	public Book() {
		title = "";
		author = "";
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	

	public int getId() {
		return id;
	}
	
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	

	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	} 
	
	
	
	
}
