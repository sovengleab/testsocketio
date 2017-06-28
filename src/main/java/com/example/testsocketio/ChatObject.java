package com.example.testsocketio;

public class ChatObject {
	private String name;
	public ChatObject(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ChatObject() {
		super();
	}
	
	
}
