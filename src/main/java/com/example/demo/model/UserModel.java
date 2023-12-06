package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_collection")
public class UserModel {
    @Id
    private String id;
    private String username;
    private String password;
    private Date birthDay;
}
