package com.parfait.study.graphql.album;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, Long> {
    List<Album> findByTitleContaining(String title);
}
