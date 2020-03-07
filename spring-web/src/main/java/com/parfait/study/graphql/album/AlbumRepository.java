package com.parfait.study.graphql.album;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, Long> {
}
