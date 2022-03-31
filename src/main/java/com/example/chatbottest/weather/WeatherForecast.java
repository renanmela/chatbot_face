package com.example.chatbottest.weather;

import com.example.chatbottest.FacebookMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherForecast implements Serializable {
    private String date;
    private int max;
    private int min;
}
