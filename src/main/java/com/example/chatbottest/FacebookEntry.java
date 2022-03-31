package com.example.chatbottest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacebookEntry implements Serializable {
    private String id;
    private Long time;
    private List<FacebookMessaging> messaging = new ArrayList<>();
	
    public List<FacebookMessaging> getMessaging() {
		return messaging;
	}
	public void setMessaging(List<FacebookMessaging> messaging) {
		this.messaging = messaging;
	}

}
