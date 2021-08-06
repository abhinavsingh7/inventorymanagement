package com.inventory.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Only this class class need to enable swagger with 2 maven dependencies
 * @author Abhinav Singh
 *
 */
@Component
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	private static String APP_TITLE="Inventory Management System";
	private static String APP_DESC="This Portal contains API to support Inventory Management";
	private static String APP_VERSION="1.0.0";
	
	 @Bean
	    public Docket api(){
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(getApiInfo())
	        		.securityContexts(Arrays.asList(securityContext()))
	        	    .securitySchemes(Arrays.asList(apiKey()))
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build();
	               
	    }

	    private ApiInfo getApiInfo() {
	        return new ApiInfoBuilder()
	                .title(APP_TITLE)
	                .description(APP_DESC)
	                .version(APP_VERSION)
	                .build();
	    }

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");

	        registry.addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
	    
	    /**To enable jwt with swagger*/
	    private ApiKey apiKey() { 
	        return new ApiKey("JWT", "Authorization", "header"); 
	    }
	    
	    private SecurityContext securityContext() { 
	        return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	    } 

	    private List<SecurityReference> defaultAuth() { 
	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	        authorizationScopes[0] = authorizationScope; 
	        return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	    }
	    /**To enable jwt with swagger*/
}
