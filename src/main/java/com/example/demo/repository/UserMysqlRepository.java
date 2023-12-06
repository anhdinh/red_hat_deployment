package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserMysqlRepository extends CrudRepository<UserEntity,Long> {
}
