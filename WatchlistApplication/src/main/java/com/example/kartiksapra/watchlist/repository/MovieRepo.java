package com.example.kartiksapra.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kartiksapra.watchlist.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
