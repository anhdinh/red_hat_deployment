package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserMysqlRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
