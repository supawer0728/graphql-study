package com.parfait.study.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mongodb.MongoClientOptions;

@Profile("heroku")
@Configuration
public class MongoConfig {

    @Bean
    public MongoClientOptions offRetryWrites() {
        return MongoClientOptions.builder()
                                 .socketTimeout(1000)
                                 .connectTimeout(20000)
                                 .retryWrites(false)
                                 .build();
    }
}
