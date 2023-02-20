package org.qmacias.products.service;

import org.qmacias.products.service.cmd.application.CreateProductCommandInterceptor;

import org.axonframework.commandhandling.CommandBus;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ProductsServiceApplication {

	public static void main(String[] args) {
 		SpringApplication.run(ProductsServiceApplication.class, args);
	}

	@Autowired
	public void registerCreateProductCommandInterceptor(ApplicationContext context, CommandBus commandBus) {
		commandBus.registerDispatchInterceptor(context.getBean(CreateProductCommandInterceptor.class));
	}

}
