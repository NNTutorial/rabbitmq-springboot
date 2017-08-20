package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TestSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange topic;

	public void send(String key,String message) {
		template.convertAndSend(topic.getName(), key, message);
	}

}