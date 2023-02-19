package com.monstarbill.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
//	@Bean
//	public WebFluxConfigurer corsMappingConfigurer() {
//	    return new WebFluxConfigurer() {
//	        @Override
//	        public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**")
//				.allowedOrigins("http://43.205.33.156:8080")
//				.allowedOrigins("http://43.205.33.156:8082");
//	        }
//	    };
//	}

}
