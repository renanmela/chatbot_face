package com.example.chatbottest.weather;

import com.example.chatbottest.FacebookMessaging;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherResults implements Serializable{
        private int temp;
        private String date;
        private String description;
        private String city_name;
        private List<WeatherForecast> forecast = new ArrayList<>();

    }
