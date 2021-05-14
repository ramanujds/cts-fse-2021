package com.cts.example.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private Date timestamp;
	
	private HttpStatus status;
	
	private String error;
	
	private String message;
	
	private String path;
	
	
}
