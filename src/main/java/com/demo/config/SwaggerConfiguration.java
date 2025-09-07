package com.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("moneymap")
                .pathsToMatch("/**")
                .packagesToScan("com.demo.resources")
                .build();
    }
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("MoneyMap")
                .description("Gerenciamento Financeiro Pessoal")
                .version("1.0")
                .contact(new Contact().name("Curso Spring")
                        .url("https://github.com/JoiceBergamin/moneymap")
                        .email("joicenafef@gmail.com")));
    }
}
