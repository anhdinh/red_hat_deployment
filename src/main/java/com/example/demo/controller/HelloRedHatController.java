package com.example.demo.controller;

import com.example.demo.dto.SystemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRedHatController {

    @GetMapping("/")
    public ResponseEntity<?> hello(){
        SystemDto systemDto = new SystemDto();
        systemDto.setMessage("Hello from andy with love");
        systemDto.setStatus(200);
        return ResponseEntity.ok(systemDto);
    }
}
