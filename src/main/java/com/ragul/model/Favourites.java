package com.ragul.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class Favourites{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private long noOfFavorites = 0;

	@ManyToMany
	@JoinTable(name = "favourite_movies", joinColumns = @JoinColumn(name = "favourite_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movies> moviesList = new ArrayList<Movies>();
	
	
	@OneToOne
	private User user;
	
	public List<Movies> getMoviesList() {
		return moviesList;
	}

	public void setMovieList(List<Movies> moviesList) {
		this.moviesList = moviesList;
	}

	public long getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(long noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + moviesList + ", noOfFavorites=" + noOfFavorites + "]";
	}

	
}
