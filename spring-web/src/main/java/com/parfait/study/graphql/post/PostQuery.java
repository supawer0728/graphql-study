package com.parfait.study.graphql.post;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.parfait.study.graphql.util.PageableUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PostQuery implements GraphQLQueryResolver {
    private final PostRepository repository;

    public List<Post> posts(Integer limit) {
        return repository.findAll(PageableUtils.limit(limit)).getContent();
    }

    public Post post(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
