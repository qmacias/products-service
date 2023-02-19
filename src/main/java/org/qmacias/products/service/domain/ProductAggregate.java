package org.qmacias.products.service.domain;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.qmacias.products.service.core.event.ProductCreatedEvent;
import org.qmacias.products.service.application.cmd.CreateProductCommand;

import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateIdentifier;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;

    private String title;

    private BigDecimal price;

    private BigInteger quantity;

    protected ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(final CreateProductCommand createProductCommand) {
        // Validate Create Product Command here
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product cannot be less or equal to zero");
        }

        if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot br empty");
        }

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(final ProductCreatedEvent productCreatedEvent) {
        this.productId = productCreatedEvent.getProductId();
        this.price = productCreatedEvent.getPrice();
        this.title = productCreatedEvent.getTitle();
        this.quantity = productCreatedEvent.getQuantity();
    }

}