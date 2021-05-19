package com.cts.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.pojo.Trainee;

@RestController
public class TraineeController {

	Map<Integer, Trainee> trainees;
	
	@PostConstruct
	public void init() {
		trainees=new HashMap<>();
		trainees.put(1001, new Trainee(1001, "Rahul"));
		trainees.put(1002, new Trainee(1002, "Lokesh"));
		trainees.put(1003, new Trainee(1003, "Harsh"));
	}
	
	
	
	@GetMapping("/trainees/{id}")
	public Trainee getTrainee(@PathVariable int id) {
		return trainees.get(id);
	}
	
	@PostMapping("/trainees")
	public Trainee addTrainee(@RequestBody Trainee trainee) {
		trainees.put(trainee.getTraineeId(), trainee);
		return trainee;
	}
	
	
	@GetMapping("/trainees")
	public List<Trainee> getAllTrainees() {
		List<Trainee> traineeList=new ArrayList<>();
		trainees.forEach((k,v)->{
			traineeList.add(v);
		});
		return traineeList;
		
	}
	
	
}
