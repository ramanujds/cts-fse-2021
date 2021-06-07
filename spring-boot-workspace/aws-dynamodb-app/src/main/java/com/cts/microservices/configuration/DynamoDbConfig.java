package com.cts.microservices.configuration;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

//@Configuration
//@EnableDynamoDBRepositories(basePackages = {"com.cts.microservices.repository"})
//public class DynamoDbConfig {
//	
//	@Value("${amazon.dynamodb.endpoint}")
//	private String dynamoDbEndpoint;
//	
//	@Value("${amazon.aws.accesskey}")
//	private String awsAccessKey;
//	
//	@Value("${amazon.aws.secretkey}")
//	private String awsSecretKey;
//	
//	
//	@Bean
//	public AWSCredentials getAwsCredentials() {
//		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
//	}
//	
//	@Bean
//	public AmazonDynamoDB getAmazonDynamoDB() {
//		AmazonDynamoDB db=new AmazonDynamoDBClient(getAwsCredentials());
//		
//		db.setEndpoint(dynamoDbEndpoint);
//		
//		return db;
//	}
//	
//	

//}
