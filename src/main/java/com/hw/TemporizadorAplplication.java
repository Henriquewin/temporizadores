package com.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hw.converter.StringToLocalDateTimeConverter;

@SpringBootApplication
@EnableAutoConfiguration
public class TemporizadorAplplication {
    public static void main(String[] args) {
        SpringApplication.run(TemporizadorAplplication.class, args);
    }
    
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateTimeConverter());
    }
}
}