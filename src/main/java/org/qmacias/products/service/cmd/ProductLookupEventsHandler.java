package org.qmacias.products.service.cmd;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;

import org.qmacias.products.service.core.data.ProductLookupEntity;
import org.qmacias.products.service.core.data.ProductLookupRepository;
import org.qmacias.products.service.core.event.ProductCreatedEvent;

import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

    final ProductLookupRepository productLookupRepository;

    public ProductLookupEventsHandler(final ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    @EventHandler
    public void on(final ProductCreatedEvent event) {
        ProductLookupEntity productLookupEntity = new ProductLookupEntity(
                event.getProductId(), event.getTitle()
        );

        productLookupRepository.save(productLookupEntity);
    }

}
