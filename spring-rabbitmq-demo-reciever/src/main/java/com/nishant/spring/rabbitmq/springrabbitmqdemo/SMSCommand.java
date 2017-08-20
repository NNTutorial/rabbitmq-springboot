package com.nishant.spring.rabbitmq.springrabbitmqdemo;

public class SMSCommand {

	private String mobileno;
	private String routekey;
	private String message;

	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getRoutekey() {
		return routekey;
	}
	public void setRoutekey(String routekey) {
		this.routekey = routekey;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
