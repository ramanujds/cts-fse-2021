package com.cts.rest.api.rds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity

public class Trainee {

	@Id @GeneratedValue
	private long traineeId;
	private String traineeName;
	private String email;
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	public long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Trainee(long traineeId, String traineeName, String email) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", email=" + email + "]";
	}
	
	
	
	
	
}
