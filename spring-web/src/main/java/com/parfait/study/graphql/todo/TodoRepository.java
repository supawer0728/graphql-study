package com.parfait.study.graphql.todo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, Long> {
    List<Todo> findByTitleContaining(String title);
}
