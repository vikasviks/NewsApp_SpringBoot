package com.newsapp.wishlist;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Wishlist Service", version = "1.0", description = "API for managing User's Wishlist"))

public class WishlistServiceApplication {

	@Configuration
	class OpenApiConfig
	{
		@Bean
		public OpenAPI customconfig()
		{
			final String securitySchemeName = "Bearer Authentication";
			return new OpenAPI().addSecurityItem(new SecurityRequirement()
					.addList(securitySchemeName)).components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme()
					.name(securitySchemeName).type(SecurityScheme.Type.HTTP).scheme("bearer")
					.bearerFormat("JWT")));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WishlistServiceApplication.class, args);
	}

}
