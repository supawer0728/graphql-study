package com.parfait.study.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import com.parfait.study.graphql.vehicle.Airplane;
import com.parfait.study.graphql.vehicle.Car;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public SchemaParserDictionary schemaParserDictionary() {
        return new SchemaParserDictionary()
                .add("Car", Car.class)
                .add("Airplane", Airplane.class);
    }
}
