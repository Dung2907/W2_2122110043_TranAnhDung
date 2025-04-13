package com.trananhdung.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("E-Commerce API")
                                                .description("API for E-Commerce application BY web_2")
                                                .version("v1.0.0")
                                                .contact(new Contact()
                                                                .name("Tran Anh Dung")
                                                                .email("anhdungtran2015@gmail.com"))
                                                .license(new License().name("License").url("/")))
                                .externalDocs(new ExternalDocumentation()
                                                .description("E-Commerce API Documentation")
                                                .url("http://localhost:8080/swagger-ui/index.html"));
        }
}