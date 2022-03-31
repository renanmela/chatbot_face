package com.example.chatbottest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacebookMessageResponse implements Serializable {
    private String message_type;
	private Map<String,String> recipient = new HashMap<>();
    private Map<String,String> message = new HashMap<>();
    
    public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}
	public Map<String, String> getRecipient() {
		return recipient;
	}
	public void setRecipient(Map<String, String> recipient) {
		this.recipient = recipient;
	}
	public Map<String, String> getMessage() {
		return message;
	}
	public void setMessage(Map<String, String> message) {
		this.message = message;
	}
}

