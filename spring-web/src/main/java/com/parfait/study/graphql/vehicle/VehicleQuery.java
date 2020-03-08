package com.parfait.study.graphql.vehicle;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class VehicleQuery implements GraphQLQueryResolver {
    private final VehicleRepository repository;

    public Vehicle vehicle(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
