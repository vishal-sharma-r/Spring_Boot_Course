package com.vsr.springcoredemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    // Define our destroy method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
    }
    // Define destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-) ^_^";
    }
}
