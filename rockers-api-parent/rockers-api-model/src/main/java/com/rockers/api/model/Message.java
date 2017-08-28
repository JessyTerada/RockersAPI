package com.rockers.api.model;

import lombok.Data;

@Data
public class Message {

	public String message;
	
	public Message(String message) {
		this.message = message;
	}
}
