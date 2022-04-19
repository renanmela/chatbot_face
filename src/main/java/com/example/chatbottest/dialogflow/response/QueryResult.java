package com.example.chatbottest.dialogflow.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueryResult {
    private List<Message> fulfillmentMessages = new ArrayList<>();
    private List<Struct> parameters = new ArrayList<>();
}
