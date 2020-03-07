package com.parfait.study.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class HelloQuery implements GraphQLQueryResolver {

    public String hello() {
        return "Hello world";
    }
}
