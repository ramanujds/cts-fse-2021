package com.cts.example.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.example.dto.ErrorResponse;
import com.cts.example.error.InvalidDobException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class TraineeErrorController {
	
	
	@PostConstruct
	public void init() {
		log.info("Created Error Controller");
	}

	@ExceptionHandler(InvalidDobException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidDobError(InvalidDobException ex, HttpServletRequest request) {
		log.info("Reached Error Controller");
		return new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST,ex.getClass().getCanonicalName(),ex.getMessage(),request.getRequestURI().toString());
		
		
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleInvalidOtherError(Exception ex, HttpServletRequest request) {
		log.info("Reached Error Controller");
		return new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR,ex.getClass().getCanonicalName(),ex.getMessage(),request.getRequestURI().toString());
		
		
	}
}
