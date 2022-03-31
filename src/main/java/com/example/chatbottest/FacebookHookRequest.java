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
public class FacebookHookRequest implements Serializable {
    private String object;
    private List<FacebookEntry> entry = new ArrayList<>();
	
    public List<FacebookEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<FacebookEntry> entry) {
		this.entry = entry;
	} 
}
