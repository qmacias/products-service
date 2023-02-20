package org.qmacias.products.service.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.qmacias.products.service.core.data.ProductEntity;
import org.qmacias.products.service.core.data.ProductRepository;
import org.qmacias.products.service.core.event.ProductCreatedEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.axonframework.eventhandling.EventHandler;

@Component
@ProcessingGroup("product-group")
public class ProductEventsHandler {

    final ProductRepository productRepository;

    public ProductEventsHandler(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @ExceptionHandler()
//    public void handle(Exception exception) throws Exception {
//        throw exception;
//    }
//
//    @ExceptionHandler(resultType = IllegalArgumentException.class)
//    public void handle(IllegalArgumentException exception) {
//    }

    @EventHandler
    public void on(final ProductCreatedEvent event) throws Exception {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        try {
            productRepository.save(productEntity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

//        if (true) throw new Exception("Forcing exception in the Event Handler class.");
    }

}
