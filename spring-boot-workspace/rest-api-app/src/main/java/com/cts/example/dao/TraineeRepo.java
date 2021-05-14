package com.cts.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.example.model.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Integer> {
	
	@Query("from Trainee where traineeName=:traineeName")
	Trainee findByTraineeName(String traineeName);

}
