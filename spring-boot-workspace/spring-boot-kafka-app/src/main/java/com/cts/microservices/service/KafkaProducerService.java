package com.cts.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducerService {
	

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${TOPIC_NAME}")
	String topicName;
	
	public void sendMessage(String message) {
		log.info("Sendting Message : "+message);
		this.kafkaTemplate.send(topicName, message);
		log.info("Message Sent");
	}
	
	
	
	
}
