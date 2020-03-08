package com.parfait.study.graphql.util;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PageableUtils {
    public static final PageRequest UNLIMITED = PageRequest.of(0, Integer.MAX_VALUE);

    public static Pageable limit(Integer limit) {
        return Optional.ofNullable(limit)
                       .map(l -> PageRequest.of(0, l))
                       .orElse(UNLIMITED);
    }
}
