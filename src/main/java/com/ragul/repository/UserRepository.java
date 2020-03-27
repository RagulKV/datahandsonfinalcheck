package com.ragul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragul.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
