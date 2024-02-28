package com.vsr.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.SaslClient;
import java.util.Scanner;
@RestController
public class myapi{
   @GetMapping("/vishal")
    public String getName(){
        return "Vishal";
    }
}
