package com.cts.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class KafkaConsumerrService {

	
	@Value("${TOPIC_NAME}")
	 String topicName;
	
	@Value("${GROUP_ID}")
	String gId;
	
	@KafkaListener(groupId = "${TOPIC_NAME}", topics = "${GROUP_ID}")
	public void receiveMessage(String message) {
		log.info("Message Received - "+message);
	}
	
	
}
