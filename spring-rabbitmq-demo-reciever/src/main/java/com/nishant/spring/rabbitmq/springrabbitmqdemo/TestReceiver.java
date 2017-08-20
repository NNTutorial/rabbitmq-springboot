package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class TestReceiver {

	@Autowired
	private RestTemplate restTemplate;

	@RabbitListener(queues = "#{autoDeleteQueue1.name}")
	public void receive1(String in) throws InterruptedException {
		receive(in, 1);
	}

	@RabbitListener(queues = "#{autoDeleteQueue2.name}")
	public void receive2(String in) throws InterruptedException {
		receive(in, 2);
	}

	public void receive(String in, int receiver) throws InterruptedException {
		if(receiver==1) {
			System.out.println("instance " + receiver + " [x] Received '"  + in + "'");
			Gson g=new Gson();
			SMSCommand sms=g.fromJson(in, SMSCommand.class);
			restTemplate.postForObject("http://localhost:8082/movie/subscribe", sms, String.class);
		}
		if(receiver==2) {
			System.out.println("instance " + receiver + " [x] Received '"  + in + "'");
			Gson g=new Gson();
			SMSCommand sms=g.fromJson(in, SMSCommand.class);
			restTemplate.postForObject("http://localhost:8083/songs/subscribe", sms, String.class);
		}
		Thread.sleep(100);
	}
}