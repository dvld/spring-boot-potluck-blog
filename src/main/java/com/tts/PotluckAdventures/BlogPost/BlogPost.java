package com.tts.PotluckAdventures.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Author;
	private String Body;
	private String Title;
	
	// getters and setters
	// ===================
	
	public long getId() {
		return id;
	}
	
	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	// =================================

	// empty constructor
	// ===================
	
	public BlogPost() {
		
	}
	
	// constructor
	// ===================
	
	public BlogPost(String author, String body, String title) {
		this.Author = author;
		this.Body = body;
		this.Title = title;
	}
	
	// prints object properties as a string
	// ===================
	
	@Override
	public String toString() {
		return "id: " + id + " Author: " + Author + " Body: " + Body + " Title: " + Title;
		
	}
}
