package com.parfait.study.graphql.album;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.parfait.study.graphql.user.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Document
public class Album {

    @Id
    private Long id;

    @Transient
    private Long userId;
    private User user;
    private String title;
    private Set<Photo> photos;

    @JsonCreator
    public Album(@JsonProperty Long id,
                 @JsonProperty Long userId,
                 @JsonProperty String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public Album initializeUser(@NonNull User user) {
        if (Objects.nonNull(this.user)) {
            throw new IllegalStateException("user is already initialized");
        }
        this.user = user;
        return this;
    }

    public Album initializePhotos(@NonNull Set<Photo> photos) {
        if (Objects.nonNull(this.photos)) {
            throw new IllegalStateException("photos is already initialized");
        }
        this.photos = photos;
        return this;
    }
}
