package com.cts.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.example.dao.TraineeRepo;
import com.cts.example.dto.TraineeDto;
import com.cts.example.error.InvalidDobException;
import com.cts.example.model.Trainee;

import io.swagger.v3.oas.annotations.servers.Server;
@Service
public class TraineeServiceImpl implements ITraineeService {

	@Autowired
	TraineeRepo repo;
	
	private TraineeDto traineeToDto(Trainee trainee) {
		TraineeDto dto=new TraineeDto();
		dto.setDob(trainee.getDob());
		dto.setTraineeName(trainee.getTraineeName());
		dto.setEmail(trainee.getEmail());
		dto.setTraineeId(trainee.getTraineeId());
		int age=LocalDate.now().getYear()-trainee.getDob().getYear();
		dto.setAge(age);
		return dto;
	}
	
	private Trainee dtoToTrainee(TraineeDto dto) {
		Trainee trainee=new Trainee();
		trainee.setDob(dto.getDob());
		trainee.setTraineeName(dto.getTraineeName());
		trainee.setEmail(dto.getEmail());
		trainee.setTraineeId(dto.getTraineeId());
		return trainee;
	}
	
	
	@Override
	public TraineeDto addTrainee(TraineeDto traineeDto) {
		// TODO Auto-generated method stub
		if(traineeDto.getDob().isAfter(LocalDate.now())) {
			throw new InvalidDobException("Date of Birth should be before current date");
		}
		Trainee trainee=dtoToTrainee(traineeDto);
		trainee=repo.save(trainee);
		
		
		return traineeToDto(trainee);
	}

	@Override
	public TraineeDto getTraineeByName(String traineeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TraineeDto getTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TraineeDto> getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

}
