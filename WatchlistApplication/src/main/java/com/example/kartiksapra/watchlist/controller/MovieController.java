package com.example.kartiksapra.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.example.kartiksapra.watchlist.entity.Movie;
import com.example.kartiksapra.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/index")
	public ModelAndView homepage() {
		// TODO Auto-generated method stub
		return new ModelAndView("index");
	}
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		// TODO Auto-generated method stu

		String viewName = "watchlistItemForm";
		Map<String, Object> model = new HashMap<>();
		
		if(id == null) {
			model.put("watchlistItem", new Movie());
		}else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
//		Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(6);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("John Doe");
//		model.put("watchlistItem", dummyMovie);
		
		return new ModelAndView(viewName, model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		if(bindingResult.hasErrors()) {
			//if Errors are there, redisplay the form and let user enter again.
//			-----
			Map<String, Object> model = new HashMap<>();
			model.put("watchlistItem", movie);
			model.put("bindingResult", bindingResult);
//			------
			return new ModelAndView("watchlistItemForm",model);
		}
		/*
			if(id == null) {
			create new movie
			}else {
			update movie
			}
		 */
		Integer id = movie.getId();
		if(id == null) {
			databaseService.create(movie);
		}else {
			databaseService.update(movie, id);
		}
		
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchList() {
		// TODO Auto-generated method stub
		
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> moviesList = databaseService.getAllMovies();
		model.put("watchlistrows", moviesList);
		model.put("noofmovies", moviesList.size());
		return new ModelAndView(viewName , model);
	}
	
	@GetMapping("/deleteMovie")
	public ModelAndView removeMovie(@RequestParam Integer id) {
		// TODO Auto-generated method stub
		databaseService.deleteMovieById(id);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/watchlist");
		
		return new ModelAndView(redirectView);
	}
}
