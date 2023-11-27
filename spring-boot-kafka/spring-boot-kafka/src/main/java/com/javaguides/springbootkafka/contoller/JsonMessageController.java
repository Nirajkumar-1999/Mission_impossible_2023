package com.javaguides.springbootkafka.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springbootkafka.kafka.JsonKafkaProducer;
import com.javaguides.springbootkafka.payload.User;

@RestController
@RequestMapping("api/kafka")
public class JsonMessageController {
	
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sentMessage(user);
		return ResponseEntity.ok("json message sent to kafka topic");
	}

}
