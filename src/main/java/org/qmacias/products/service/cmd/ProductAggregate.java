package org.qmacias.products.service.cmd;

import org.qmacias.products.service.core.event.ProductCreatedEvent;
import org.qmacias.products.service.cmd.application.CreateProductCommand;

import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
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

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(final CreateProductCommand createProductCommand) {
        // Validate Create Product Command here
        if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product cannot be less or equal to zero");
        }

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);

//        throw new Exception("An error took place in the CreateProductCommand @CommandHandler method.");
    }

    @EventSourcingHandler
    public void on(final ProductCreatedEvent productCreatedEvent) {
        this.productId = productCreatedEvent.getProductId();
        this.title = productCreatedEvent.getTitle();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }

}