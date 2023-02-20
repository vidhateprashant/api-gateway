package com.monstarbill.apigateway;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig extends CorsConfiguration {

	@Bean
	public CorsWebFilter corsFilter() {
	//	return new CorsWebFilter(corsConfigurationSource());
		CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials( true );
        config.setAllowedOrigins( List.of( "http://43.205.33.156:8080","http://43.205.33.156:8082","http://43.205.33.156:8081" ,"http://localhost:8080" ) );
        config.setAllowedMethods( List.of( "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD" ) );
        config.setAllowedHeaders( List.of("*") );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration( "/**", config );

        return new CorsWebFilter( source );
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		System.out.println("=========== API Gateway : CorsConfig : corsConfigurationSource ");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
//		config.addAllowedMethod("*");
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.setMaxAge(99999L);

		source.registerCorsConfiguration("/**", config);
		return source;
	}

}