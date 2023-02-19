package org.qmacias.products.service.rest.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class CreateProductRestModel {

    private String title;

    private BigDecimal price;

    private BigInteger quantity;

}
