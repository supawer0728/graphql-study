package com.parfait.study.graphql.album;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AlbumQuery implements GraphQLQueryResolver {

    private final AlbumRepository repository;

    public List<Album> albums() {
        return repository.findAll();
    }

    public Album album(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
