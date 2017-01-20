package com.kms.demo.model;

import java.io.Serializable;

public class Message implements Serializable{
	
	private String payload;
	private Long id;
	
	public Message(){}

	public Message(String payload, Long id) {
		this.payload = payload;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message [payload=" + payload + ", id=" + id + "]";
	}

	public String getPayload() {
		return payload;
	}

	public Long getId() {
		return id;
	}
	
}
