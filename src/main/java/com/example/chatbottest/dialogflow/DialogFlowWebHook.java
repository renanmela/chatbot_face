package com.example.chatbottest.dialogflow;

import com.example.chatbottest.dialogflow.request.QueryInput;
import com.example.chatbottest.dialogflow.request.TextInput;
import com.example.chatbottest.dialogflow.request.intentRequest;
import com.example.chatbottest.dialogflow.response.*;
import com.example.chatbottest.weather.WeatherWebHook;
import com.google.protobuf.StringValue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("dfwebhook")
public class DialogFlowWebHook {
    private final RestTemplate template = new RestTemplate();
    String DF_INTENT_URL = "https://dialogflow.googleapis.com/v2/projects/chatbot-facebook-hxlb/agent/sessions/123456789:detectIntent";

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String post(String message) {
        intentRequest request = new intentRequest();
        intentResponse response = new intentResponse();
        for (QueryInput queryInput : request.getQueryInput()) {
            for (TextInput textInput : queryInput.getText()) {
                textInput.setText(message);
                textInput.setLanguageCode("pt-BR");
                HttpEntity<intentRequest> entity = new HttpEntity<>(request);
                response = template.postForEntity(DF_INTENT_URL, entity, intentResponse.class).getBody();
            }
        }
        return getTextResponse(response);
    }

    public String getTextResponse(intentResponse response){
        WeatherWebHook weather = new WeatherWebHook();
        String textResponse = "";
        String city_name = "";
        String date;
        for (QueryResult queryResult : response.getQueryResult()) {
            for (Message message : queryResult.getFulfillmentMessages()) {
                int i = 0;
                for (Text text : message.getText()) {
                    textResponse += text.getText()[i];
                    i++;
                }
            }
            for (Struct struct : queryResult.getParameters()) {
                city_name = String.valueOf(struct.getFields().get("geo_city"));
                date = String.valueOf(struct.getFields().get("date-time"));
            }
        }
        textResponse += weather.getWeather(city_name);
        return textResponse;
    }
}