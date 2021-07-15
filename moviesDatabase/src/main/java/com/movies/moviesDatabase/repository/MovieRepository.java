package com.movies.moviesDatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.moviesDatabase.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	public List<Movie> findAllByTitleContainingIgnoreCase(String title);
	
	public List<Movie> findAllByGenresContainingIgnoreCase(String genres);

}
