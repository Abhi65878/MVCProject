package com.example.kartiksapra.watchlist.entity;

import com.example.kartiksapra.watchlist.entity.validations.Priority;
import com.example.kartiksapra.watchlist.entity.validations.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@jakarta.validation.constraints.NotBlank(message = "Please enter the title")
	private String title;
	
	@Rating
	private float rating;
	
	@Priority
	private String priority;
	
	@Size(max = 50, message = "Comment should be maximum 50 Characters")
	private String comment;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
