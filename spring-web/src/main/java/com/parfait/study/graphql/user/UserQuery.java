package com.parfait.study.graphql.user;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository repository;

    public User user(Long id) {
        if (Objects.isNull(id)) {
            id = 1L;
        }
        return repository.findById(id).orElseThrow();
    }
}
