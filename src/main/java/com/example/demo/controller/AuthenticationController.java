package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {


    @GetMapping("/welcome")
    private String wellCome(){
        return "welcome";
    }

    @GetMapping("/admin")
    private String admin(){
        return "admin";
    }

}
