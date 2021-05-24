package com.cts.rest.api.rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.rest.api.rds.model.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Long> {

}
