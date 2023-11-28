package com.javaguides.springbootrabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
	
	 @Value("${rabbitmq.exchange.name}")
	    private String exchange;

	    @Value("${rabbitmq.routing.key}")
	    private String routingKey;
	    
	    private RabbitTemplate rabbitTemplate;
	    
	    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

		public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
			super();
			this.rabbitTemplate = rabbitTemplate;
		}
	    
		 public void sendMessage(String message){
		        LOGGER.info(String.format("Message sent -> %s", message));
		        rabbitTemplate.convertAndSend(exchange, routingKey, message);
		    }

}
