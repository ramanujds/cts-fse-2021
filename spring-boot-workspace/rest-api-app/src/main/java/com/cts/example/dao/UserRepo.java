package com.cts.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.example.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
