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
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    @JsonCreator
    public Company(@JsonProperty String name,
                   @JsonProperty String catchPhrase,
                   @JsonProperty String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
