package com.parfait.study.graphql.album;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Document
public class Photo {

    @Id
    private Long id;

    private String title;
    private String url;
    private String thumbnailUrl;
    private Long albumId;

    @JsonCreator
    public Photo(@JsonProperty Long id,
                 @JsonProperty String title,
                 @JsonProperty String url,
                 @JsonProperty String thumbnailUrl,
                 @JsonProperty Long albumId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.albumId = albumId;
    }
}
