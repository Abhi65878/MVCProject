package com.example.kartiksapra.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kartiksapra.watchlist.entity.Movie;
import com.example.kartiksapra.watchlist.repository.MovieRepo;

@Service
public class DatabaseService {
		
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	RatingService ratingService;
	
	public void create(Movie movie) {
		// TODO Auto-generated method stub
		
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating != null) {
			movie.setRating(Float.parseFloat(rating));    //This will change String into integer because here we can't use typecasting.
			
		}
		movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		
		return movieRepo.findAll();
	}

	public Movie getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}

	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated = getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setPriority(movie.getPriority());
		toBeUpdated.setComment(movie.getComment());
		
		movieRepo.save(toBeUpdated);
	}
	
	public void deleteMovieById(Integer id) {
		movieRepo.deleteById(id);
	}
}
