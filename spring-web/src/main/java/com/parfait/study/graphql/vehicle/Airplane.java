package com.parfait.study.graphql.vehicle;

import org.springframework.data.annotation.TypeAlias;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@TypeAlias("airplane")
public class Airplane extends Vehicle {
    private String flyLimit;

    public Airplane(Long id, String manufacturer, String name, String flyLimit) {
        super(id, manufacturer, name);
        this.flyLimit = flyLimit;
    }
}
