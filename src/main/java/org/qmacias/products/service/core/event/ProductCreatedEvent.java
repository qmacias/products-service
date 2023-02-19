package org.qmacias.products.service.core.event;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ProductCreatedEvent {

    private String productId;

    private String title;

    private BigDecimal price;

    private BigInteger quantity;

}
