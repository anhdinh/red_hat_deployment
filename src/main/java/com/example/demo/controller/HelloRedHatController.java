package com.example.demo.controller;

import com.example.demo.dto.ErrorDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloRedHatController {

    @Autowired
    private UserMysqlRepository mysqlRepository;

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        try {
            UserEntity userModel = UserEntity.builder().username("test").password("1234")
                    .dateOfBirth(new Date()).build();
            UserEntity savedUser = mysqlRepository.save(userModel);
            return ResponseEntity.ok(savedUser);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(
                    ErrorDto.builder().status(500).message(ex.getMessage()).build());
        }

    }
}
