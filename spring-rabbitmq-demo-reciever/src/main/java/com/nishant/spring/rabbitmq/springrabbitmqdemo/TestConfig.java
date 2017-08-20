package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {

	@Bean
	public RestTemplate getrestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public TopicExchange topic() {
		return new TopicExchange("nntutorial.exchange");
	}

	@Bean
	public TestReceiver receiver() {
		return new TestReceiver();
	}

	@Bean
	public Queue autoDeleteQueue1() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding binding1a(TopicExchange topic, 
			Queue autoDeleteQueue1) {
		return BindingBuilder.bind(autoDeleteQueue1)
				.to(topic)
				.with("*.movie.*");
	}
	@Bean
	public Queue autoDeleteQueue2() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding binding2a(TopicExchange topic, 
			Queue autoDeleteQueue2) {
		return BindingBuilder.bind(autoDeleteQueue2)
				.to(topic)
				.with("*.songs.*");
	}

}