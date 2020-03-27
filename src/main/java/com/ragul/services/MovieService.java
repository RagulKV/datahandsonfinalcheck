package com.ragul.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragul.model.Movies;
import com.ragul.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository mr;
	
	public void modifyMovie(Movies movie) {
		mr.save(movie);
	}

	public Movies getMovie(long movieId) {
		return mr.findById(movieId).get();
	}

	public List<Movies> getMovieListAdmin() {
		return mr.findAll();
	}

	public List<Movies> getMovieListCustomer() {
		Date date = new Date();
		return mr.getMoviesListCustomer(date);
	}

	
	
}
