package com.example.demo.repository;

import com.example.demo.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserModel,String> {
}
