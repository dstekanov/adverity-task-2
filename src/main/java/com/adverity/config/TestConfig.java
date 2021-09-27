package com.adverity.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
@ComponentScan(basePackages = { "com.adverity" })
public class TestConfig {

    @Value("${ui.app.url}")
    private String appUrl;

    public String appUrl() {
        return appUrl;
    }

}
