package com.cts.rest.api.rds.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rest.api.rds.model.Trainee;
import com.cts.rest.api.rds.repository.TraineeRepo;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class TraineeController {
	
	@Autowired
	TraineeRepo repo;

	@GetMapping("/trainees")
	public List<Trainee> getAllTrainees(){
		Log.info("Fetched All Trainees");
		return repo.findAll();
	}
	
	@PostMapping("/trainees")
	@Transactional
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		System.out.println(trainee);
		return repo.save(trainee);
	}
	
	
}
