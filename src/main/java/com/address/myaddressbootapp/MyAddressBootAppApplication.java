package com.address.myaddressbootapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = "Address API", version = "1.0", description = "Megatron"))
public class MyAddressBootAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MyAddressBootAppApplication.class, args);
	}
}