package com.graphql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Configuration
public class GraphQLClientConfig {
    @Autowired
    private Environment env;

    @Bean
    public HttpGraphQlClient graphQlClient() {
        return HttpGraphQlClient.builder(webClient()).build();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(Objects.requireNonNull(env.getProperty("graphQl.server.url"))).build();
    }
}
