package com.cirodeleon.apps.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public MappingJackson2XmlHttpMessageConverter xmlHttpMessageConverter() {
        return new MappingJackson2XmlHttpMessageConverter();
    }

    @Bean
    public List<HttpMessageConverter<?>> configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(xmlHttpMessageConverter());
        return converters;
    }
}


