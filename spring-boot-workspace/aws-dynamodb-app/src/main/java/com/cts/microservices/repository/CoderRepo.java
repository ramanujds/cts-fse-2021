package com.cts.microservices.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cts.microservices.model.Coder;


public interface CoderRepo extends CrudRepository<Coder, Integer>{

	Optional<Coder> findById(int id);
	
	
}
