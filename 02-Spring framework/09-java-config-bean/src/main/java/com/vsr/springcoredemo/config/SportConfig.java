package com.vsr.springcoredemo.config;

import com.vsr.springcoredemo.common.Coach;
import com.vsr.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // bean-id default to the method name.
    @Bean("aquatic") // giving our own bean-id
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
