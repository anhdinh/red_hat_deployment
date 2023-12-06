package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloRedHatController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<?> hello(){
        UserModel userModel = UserModel.builder().username("test").password("1234").birthDay(new Date()).build();
        UserModel savedUser= userRepository.save(userModel);
        return ResponseEntity.ok(savedUser);
    }
}
