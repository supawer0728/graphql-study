package com.parfait.study.graphql.user;

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
public class GeoLocation {
    private String lat;
    private String lng;

    @JsonCreator
    public GeoLocation(@JsonProperty String lat, @JsonProperty String lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
