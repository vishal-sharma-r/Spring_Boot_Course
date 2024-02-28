package com.vsr.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennnisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
