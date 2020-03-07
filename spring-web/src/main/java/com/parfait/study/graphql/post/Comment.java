package com.parfait.study.graphql.post;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Comment {
    @Id
    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;

    @JsonCreator
    public Comment(@JsonProperty Long id,
                   @JsonProperty Long postId,
                   @JsonProperty String name,
                   @JsonProperty String email,
                   @JsonProperty String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
