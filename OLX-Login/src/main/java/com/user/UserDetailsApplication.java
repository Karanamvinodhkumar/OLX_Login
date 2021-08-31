package com.user;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableEurekaClient
public class UserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
	}
	
	@Bean
	public Docket getDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.any())
		.apis(RequestHandlerSelectors.basePackage("com.user"))
		.build()
		.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo()
	{
		return new ApiInfo(
				"User Rest API Implementation",
				"API designed for User details",
				"1.0.0",
				"http://www.zensar.com",
				new Contact("vinodh","http://www.userdetails.com","users.k@zensar.com"),
				"GPL",
				"http://www.gpllicense.com",
				new ArrayList<>()
		
				);
	}

}
