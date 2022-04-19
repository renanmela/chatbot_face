package com.example.chatbottest.dialogflow.request;

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
public class intentRequest {
    private List<QueryInput> queryInput = new ArrayList<>();
}
