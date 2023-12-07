package com.example.demo.controller;

import com.example.demo.dto.UserRequestRegisterDto;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    private String register(Model model){
        model.addAttribute("user",new UserRequestRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    private String registerProcess(@ModelAttribute("user") @Valid UserRequestRegisterDto user, BindingResult bindingResult){
       try {
           if (bindingResult.hasErrors()){
               return "register";
           }
           user.setPassword("abc@123");
           userService.createUser(user);
           return "redirect:login";
       }catch (Exception e){
           log.error(e.getMessage());
           bindingResult.addError(new FieldError("user","username",e.getMessage()));
           return "register";
       }
    }
}
