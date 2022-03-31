package com.example.chatbottest;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacebookMessage implements Serializable {
    private String mid;
    private String text;
	
    public String getText() {
		return text;
	}
}
