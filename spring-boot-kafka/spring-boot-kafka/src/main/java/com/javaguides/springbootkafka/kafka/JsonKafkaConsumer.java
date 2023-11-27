package com.javaguides.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.javaguides.springbootkafka.payload.User;

public class JsonKafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@KafkaListener(topics="javaguides",groupId="myGroup")
	public void consume(User user) {
		
		LOGGER.info(String.format("json message recievd %s",user.toString() ));
	}

}
