package com.example.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClienConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
