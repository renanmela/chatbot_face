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
public class intentResponse {
    private List<QueryResult> queryResult = new ArrayList<>();
}
