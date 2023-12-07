package com.example.demo.controller;


import com.example.demo.service.IPostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@Log4j2
public class PostController {

   private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping

    public ResponseEntity<?> getAll(){
        try {
            var response =  postService.getAll();
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
