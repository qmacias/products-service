package org.qmacias.products.service;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;

import org.qmacias.products.service.cmd.application.CreateProductCommandInterceptor;

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
        commandBus.registerDispatchInterceptor(context.getBean(
                CreateProductCommandInterceptor.class)
        );
    }

//    @Autowired
//    public void configure(EventProcessingConfigurer configurer) {
//        configurer.registerListenerInvocationErrorHandler("product-group",
//                configuration -> new ProductsServiceEventsErrorHandler()
//        );
//    }

}
