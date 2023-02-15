package org.grupo3.proyectofaltasapi.config;

import java.util.Collections;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.grupo3.proyectofaltasapi.controlador"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "GuardiasCentro API",
                "La API REST del Grupo3 para GuardiasCentro.",
                "v1",
                "Terms of service",
                new Contact("IES Miguel Herrero", "www.iesmiguelherrero.com", "ies.miguel.herrero@educantabria.es"),
                "License of API", "API license URL", Collections.emptyList());
    }
}