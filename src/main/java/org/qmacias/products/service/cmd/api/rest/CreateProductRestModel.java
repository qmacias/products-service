package org.qmacias.products.service.cmd.api.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class CreateProductRestModel {

//    @NotBlank(message = "Product title is a required field.")
    private String title;

    @Min(value = 1, message = "Price cannot be lower than 1.")
    private BigDecimal price;

    @Min(value = 0, message = "Quantity cannot be lower than 0.")
    @Max(value = 5, message = "Quantity cannot be larger than 5.")
    private BigInteger quantity;

}
