package com.vsr.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennnisCoach implements Coach{
    public TennnisCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
