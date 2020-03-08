package com.parfait.study.graphql.todo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.parfait.study.graphql.util.PageableUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TodoQuery implements GraphQLQueryResolver {

    private final TodoRepository repository;

    public List<Todo> todos(Integer limit) {
        return repository.findAll(PageableUtils.limit(limit))
                         .getContent();
    }

    public Todo todo(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
