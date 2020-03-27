package com.ragul.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragul.model.Movies;


public interface MovieRepository extends JpaRepository<Movies, Long> {
	
	@Query("SELECT m from Movie m WHERE m.active=1 AND m.dateOfLaunch < :today ")
	List<Movies> getMoviesListCustomer(Date today);
}
