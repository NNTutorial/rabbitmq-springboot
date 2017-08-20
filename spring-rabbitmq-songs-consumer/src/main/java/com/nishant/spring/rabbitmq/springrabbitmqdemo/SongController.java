package com.nishant.spring.rabbitmq.springrabbitmqdemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongController {

	@RequestMapping(value="/subscribe",method=RequestMethod.POST)
	public String subscribeForSong(@RequestBody SMSCommand sms) {
		System.out.println("User with mobile number:"+sms.getMobileno()+" is subscribed for "+sms.getRoutekey());
		return "success";
	}
}
