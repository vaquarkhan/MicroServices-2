package com.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableSchemaRegistryClient
@EnableBinding(Source.class)
@EnableResourceServer
public class OrganizationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationMicroserviceApplication.class, args);
	}
}
