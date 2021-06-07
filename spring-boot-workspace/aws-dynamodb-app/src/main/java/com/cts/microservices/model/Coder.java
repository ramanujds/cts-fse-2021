package com.cts.microservices.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@DynamoDBTable(tableName = "coder")
public class Coder {

	private String id;
	private String language;
	private int yearsExp;
	
	@DynamoDBHashKey
	public String getId() {
		return id;
	}
	
	@DynamoDBAttribute
	public String getLanguage() {
		return language;
	}
	
	@DynamoDBAttribute
	public int getYearsExp() {
		return yearsExp;
	}
	
	
	
	
	
	
	
}
