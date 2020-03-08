package com.parfait.study.graphql.album;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.parfait.study.graphql.util.PageableUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AlbumQuery implements GraphQLQueryResolver {

    private final AlbumRepository repository;

    public List<Album> albums(Integer limit) {
        return repository.findAll(PageableUtils.limit(limit)).getContent();
    }

    public Album album(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
