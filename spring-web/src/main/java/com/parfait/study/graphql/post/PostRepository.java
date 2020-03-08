package com.parfait.study.graphql.post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, Long> {
    List<Post> findByTitleContaining(String title);
}
