package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tbl")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column
    private String username;
    @Column
    private String password;

    @Column(name = "day_of_birth")
    private Date dateOfBirth;

}
