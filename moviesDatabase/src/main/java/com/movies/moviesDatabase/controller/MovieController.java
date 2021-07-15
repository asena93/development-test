package com.movies.moviesDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.moviesDatabase.model.Movie;
import com.movies.moviesDatabase.repository.MovieRepository;


@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {

	@Autowired
	private MovieRepository repository;

	@GetMapping
	public ResponseEntity<List<Movie>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getByMovieId(@PathVariable long movieId) {
		return repository.findById(movieId).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<Movie>> getByTitle(@PathVariable String title) {
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
	}
	
	@GetMapping("/genres/{genres}")
	public ResponseEntity<List<Movie>> getByGenres(@PathVariable String genres) {
		return ResponseEntity.ok(repository.findAllByGenresContainingIgnoreCase(genres));
	}

	@PostMapping
	public ResponseEntity<Movie> post(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movie));
	}

	@PutMapping
	public ResponseEntity<Movie> put(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(movie));
	}

	@DeleteMapping("/{movieId}")
	public void delete(@PathVariable long movieId) {
		repository.deleteById(movieId);
	}

}
