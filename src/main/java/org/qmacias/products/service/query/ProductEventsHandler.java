package org.qmacias.products.service.query;

import org.axonframework.config.ProcessingGroup;
import org.qmacias.products.service.core.data.main.ProductEntity;
import org.qmacias.products.service.core.data.main.ProductRepository;
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

    @EventHandler
    public void on(final ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productRepository.save(productEntity);
    }

}
