package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestSender testSender;
	
	@RequestMapping(value="/addmsg",method=RequestMethod.POST)
	public String postmsg(@RequestBody SMSCommand sms) {
		Gson g=new Gson();
		String reqJson=g.toJson(sms);
		testSender.send("key."+sms.getRoutekey()+".rabbit",reqJson);
		return "Thanks for selecting "+sms.getRoutekey()+".This service will be activated in your number.";
	}
}
