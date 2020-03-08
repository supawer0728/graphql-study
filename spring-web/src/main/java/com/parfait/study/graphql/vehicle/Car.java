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
@TypeAlias("car")
public class Car extends Vehicle {
    private String tire;

    public Car(Long id, String manufacturer, String name, String tire) {
        super(id, manufacturer, name);
        this.tire = tire;
    }
}
