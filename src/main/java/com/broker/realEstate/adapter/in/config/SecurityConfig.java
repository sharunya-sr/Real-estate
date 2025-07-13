package com.broker.realEstate.adapter.in.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
        return http.authorizeHttpRequests((requests)-> requests.anyRequest().permitAll())
        .csrf(AbstractHttpConfigurer::disable)
        .headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
        .build();

    }

}
