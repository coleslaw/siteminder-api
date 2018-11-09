package com.noetic.api;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import com.noetic.api.siteminder.config.SpringApplicationContext;
import com.noetic.api.siteminder.resource.ResourceAdvice;
import com.noetic.api.siteminder.resource.ResponseFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackageClasses = {SpringApplicationContext.class, ResponseFilter.class, ResourceAdvice.class},
        basePackages = {"com.noetic.api.siteminder.resource.v1"})

public class SiteminderServiceExternalApp {

    public static void main(String[] args) {
        SpringApplication.run(SiteminderServiceExternalApp.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/v.*/(siteminder|admin).*"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Siteminder Channel Integration API")
                .description("Siteminderdocumentation")
                .termsOfServiceUrl("http://www.wearenoetic.com")
                .contact(new Contact("Noetic Digital", "http://www.wearenoetic.com", "info@wearenoetic.com"))
                .version("1.0")
                .build();
    }

}
