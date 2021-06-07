package com.cts.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.cts.microservices.model.Coder;
import com.cts.microservices.repository.CoderRepo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coders")
@Slf4j
public class CoderController {

	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	
	
	@Autowired
	CoderRepo repo;
	
	private DynamoDBMapper dbMapper;
	
	@PostConstruct
	public void init() {
		log.info("Dynamo DB Initialized");
		dbMapper=new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest=dbMapper.generateCreateTableRequest(Coder.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L,1L));
		//amazonDynamoDB.createTable(tableRequest);
		
		
	}
	
		
	@PostMapping("/coder")
	public Coder saveCoder(@RequestBody Coder coder) {
		log.info("Post Mapping for Saving Coder");
		return repo.save(coder);
	}
	
	@GetMapping
	public List<Coder> getAllCoders(){
		List<Coder> coders=(List<Coder>) repo.findAll();
		return coders;
	}
	
	
}
