package com.parfait.study.graphql.post;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.parfait.study.graphql.user.User;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    private Long id;

    @Transient
    private Long userId;
    private User user;
    private String title;
    private String body;
    private Set<Comment> comments;

    @JsonCreator
    public Post(@JsonProperty Long id,
                @JsonProperty Long userId,
                @JsonProperty String title,
                @JsonProperty String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Post initializeUser(@NonNull User user) {
        if (Objects.nonNull(this.user)) {
            throw new IllegalStateException("user is already initialized");
        }
        this.user = user;
        return this;
    }

    public Post initializeComments(@NonNull Set<Comment> comments) {
        if (Objects.nonNull(this.comments)) {
            throw new IllegalStateException("comments is already initialized");
        }
        this.comments = comments;
        return this;
    }

    public List<Comment> comments(Integer limit) {
        if (Objects.isNull(limit)) {
            limit = Integer.MAX_VALUE;
        }
        return this.comments.stream().limit(limit).collect(toList());
    }
}
