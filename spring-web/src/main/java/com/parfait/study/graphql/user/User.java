package com.parfait.study.graphql.user;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @JsonCreator
    public User(@JsonProperty Long id,
                @JsonProperty String name,
                @JsonProperty String email,
                @JsonProperty Address address,
                @JsonProperty String phone,
                @JsonProperty String website,
                @JsonProperty Company company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
}
