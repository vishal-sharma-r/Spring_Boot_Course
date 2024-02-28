package com.vsr.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @function: for mapping the https requests
 */
@RestController
public class FunRestController {
    // Injecting the Custom application properties
    @Value("${coach}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    // expose "/" that return Hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello World !...!...! Hello file changed";
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run hard to 5k!";
    }
    @GetMapping("/teamdetails")
    public String getTeamDetails(){
        return "Helo coach "+coachName + ", & also welcome team "+teamName ;
    }
}
