package com.parfait.study.graphql.todo;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parfait.study.graphql.user.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    private Long id;

    @Transient
    private Long userId;
    private User user;
    private String title;
    private boolean completed;

    public Todo(@JsonProperty Long id,
                @JsonProperty Long userId,
                @JsonProperty String title,
                @JsonProperty boolean completed) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.title = title;
        this.completed = completed;
    }

    public Todo initializeUser(@NonNull User user) {
        if (Objects.nonNull(this.user)) {
            throw new IllegalStateException("user is already initialized");
        }
        this.user = user;
        return this;
    }
}
