package com.cts.example.service;

import java.util.List;

import com.cts.example.dto.TraineeDto;

public interface ITraineeService {

	TraineeDto addTrainee(TraineeDto traineeDto);
	
	TraineeDto getTraineeByName(String traineeName);
	
	TraineeDto getTraineeById(int traineeId);
	
	List<TraineeDto> getAllTrainees();
	
	
}
