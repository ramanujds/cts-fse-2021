package com.cts.microservices;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = {"com.cts.microservices.repository"})

public class AwsDynamodbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDynamodbAppApplication.class, args);
	}
	
	
		
		@Value("${amazon.dynamodb.endpoint}")
		private String dynamoDbEndpoint;
		
		@Value("${amazon.aws.accesskey}")
		private String awsAccessKey;
		
		@Value("${amazon.aws.secretkey}")
		private String awsSecretKey;
		
		
		@Bean
		public AWSCredentials getAwsCredentials() {
			return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		}
		
		@Bean("amazonDynamoDB")
		public AmazonDynamoDB getAmazonDynamoDB() {
			AmazonDynamoDB db=new AmazonDynamoDBClient(getAwsCredentials());
			
			db.setEndpoint(dynamoDbEndpoint);
			
			return db;
		}
		
		

}
