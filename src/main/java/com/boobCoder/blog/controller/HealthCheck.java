package com.boobCoder.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog-app/")
public class HealthCheck {

    @GetMapping("/health-check")
    public String checkHealth(){
        return "Application is up and running fine !";
    }
}
