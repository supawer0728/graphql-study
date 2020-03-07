package com.parfait.study.graphql.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoLocation geo;

    public Address(@JsonProperty String street,
                   @JsonProperty String suite,
                   @JsonProperty String city,
                   @JsonProperty String zipcode,
                   @JsonProperty GeoLocation geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}
