package org.qmacias.products.service.query.api.rest;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ProductRestModel {

    private String productId;

    private String title;

    private BigDecimal price;

    private BigInteger quantity;

}
