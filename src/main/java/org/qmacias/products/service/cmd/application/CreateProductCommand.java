package org.qmacias.products.service.cmd.application;

import lombok.Data;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
public final class CreateProductCommand {

    @TargetAggregateIdentifier
    final String productId;

    final String title;

    final BigDecimal price;

    final BigInteger quantity;

}
