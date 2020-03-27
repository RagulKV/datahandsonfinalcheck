package com.ragul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ragul.model.Favourites;
import com.ragul.model.Movies;
import com.ragul.model.User;
import com.ragul.repository.FavouriteRepository;
import com.ragul.repository.MovieRepository;
import com.ragul.repository.UserRepository;


public class FavouriteService {
	
	@Autowired
	UserRepository ur;

	@Autowired
	MovieRepository mr;

	@Autowired
	FavouriteRepository fr;
	
	public void removeFavoritesMovie(long userId, long movieId) {
		User user = ur.findById(userId).get();

		Movies movie = mr.findById(movieId).get();

		Favourites favourites = user.getFavourites();
		favourites.getMoviesList().remove(movie);

		favourites.setNoOfFavorites(favourites.getNoOfFavorites() - 1);

		fr.save(favourites);
	}


	public void addFavoritesMovie(long userId, long movieId) {
		User user = ur.findById(userId).get();

		Movies movie = mr.findById(movieId).get();

		Favourites favourites = user.getFavourites();
		favourites.getMoviesList().add(movie);

		favourites.setNoOfFavorites(favourites.getNoOfFavorites() + 1);

		fr.save(favourites);
	}

	public List<Movies> getAllFavoritesMovies(long userId) {
		User user = ur.findById(userId).get();

		Favourites favorites = user.getFavourites();

		return favorites.getMoviesList();
	}

	
}
