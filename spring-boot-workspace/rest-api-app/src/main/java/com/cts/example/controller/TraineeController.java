package com.cts.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.dao.TraineeRepo;
import com.cts.example.dto.TraineeDto;
import com.cts.example.model.Trainee;
import com.cts.example.service.ITraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	TraineeRepo repo;
	
	@Autowired
	ITraineeService service;

	@GetMapping("/trainees/{traineeId}")
	public Trainee getTrainee(@PathVariable int traineeId) {
		return repo.getOne(traineeId);
	}
	
	@PostMapping("/trainees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TraineeDto addTrainee(@RequestBody TraineeDto traineeDto) {
		
		return service.addTrainee(traineeDto);
	}
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees(){
		return repo.findAll();
	}
	

	@GetMapping("/trainees/name/{traineeName}")
	public Trainee getTraineeByName(@PathVariable String traineeName) {
		return repo.findByTraineeName(traineeName);
	}
	
}
