package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserRequestRegisterDto {
    @NotBlank(message = "User's username cannot be empty.")
    @Email(message = "the email is not type email!")
    private String username;
    private String password;
    @NotBlank(message = "User's displayName cannot be empty.")
    private String displayName;
    private String gender;
    private String birthday;
    private String note;

}
