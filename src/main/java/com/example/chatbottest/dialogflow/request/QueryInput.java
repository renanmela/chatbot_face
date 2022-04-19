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
public class QueryInput {
        private List<TextInput> text = new ArrayList<>();

        public List<TextInput> getText() {
                return text;
        }

        public void setText(List<TextInput> text) {
                this.text = text;
        }
}
