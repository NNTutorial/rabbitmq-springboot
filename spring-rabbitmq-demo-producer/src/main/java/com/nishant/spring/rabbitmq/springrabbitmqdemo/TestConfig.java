package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("nntutorial.exchange");
    }

    @Bean
    public TestSender sender() {
        return new TestSender();
    }

}