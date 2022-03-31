package com.example.chatbottest;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacebookMessaging implements Serializable {
    private Map<String,String> sender;
    private Map<String,String> recipient;
    private Long timestamp;
    private FacebookMessage message;
	
    public Map<String, String> getSender() {
		return sender;
	}
	public void setSender(Map<String, String> sender) {
		this.sender = sender;
	}
	public FacebookMessage getMessage() {
		return message;
	}
	public Map<String,String> getRecipient() {
		return recipient;
	}
    
    
}
