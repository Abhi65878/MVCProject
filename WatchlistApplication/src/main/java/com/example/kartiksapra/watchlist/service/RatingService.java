package com.example.kartiksapra.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;


@Service
public class RatingService {
	String apiurl = "https://www.omdbapi.com/?apikey=a8431cee&t=";
	
	public String getMovieRating(String title) {
		// TODO Auto-generated method stub

		try {
			//We fetch the IMDB rating of move title using OMDB api
			//We use template class to call external api from here using apiurl+title.
			RestTemplate template = new RestTemplate();       //this will act as a postman/web browser.Here title is web client.
			
			//Response entity is wrapper to hold json type Object
			ResponseEntity<ObjectNode> response = template.getForEntity(apiurl + title, ObjectNode.class);
			
			//Now we will extract json object from entity.
			ObjectNode jsonObject = response.getBody();
			System.out.println(jsonObject.path("imdbRating").asText());
			return jsonObject.path("imdbRating").asText();
			
		} catch (Exception e) {
			// TODO: handle exception
			//to user entered rating will be taken
			System.out.println("Either movie name not available or api is down" + e.getMessage());
			return null;
		}
	}
}
