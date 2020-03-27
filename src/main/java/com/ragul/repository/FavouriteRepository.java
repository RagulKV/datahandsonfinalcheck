package com.ragul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragul.model.Favourites;

public interface FavouriteRepository extends JpaRepository<Favourites, Long> {

}
