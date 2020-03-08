package com.parfait.study.graphql.config;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("heroku")
@Configuration
public class MongoConfig {

    @Bean
    public MongoClientSettingsBuilderCustomizer offRetryWrites() {
        return builder -> builder.retryWrites(false);
    }
}
