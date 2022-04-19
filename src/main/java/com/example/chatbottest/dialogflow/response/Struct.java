package com.example.chatbottest.dialogflow.response;

import com.google.protobuf.StringValue;
import com.google.protobuf.Value;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Struct {
    Map<String, Value> fields;
}
