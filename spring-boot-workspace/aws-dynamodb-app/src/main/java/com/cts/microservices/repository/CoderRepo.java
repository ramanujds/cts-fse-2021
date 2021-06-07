package com.cts.microservices.repository;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.cts.microservices.model.Coder;

@EnableScan
public interface CoderRepo extends CrudRepository<Coder, Integer>{

	Optional<Coder> findById(int id);
	
	
}
