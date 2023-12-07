package com.example.demo.repository;

import com.example.demo.model.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity,Long> {
}
