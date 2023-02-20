package org.qmacias.products.service.cmd.api.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.qmacias.products.service.cmd.application.CreateProductCommand;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/products")
final class ProductsCommandController {

    final CommandGateway commandGateway;

    ProductsCommandController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody final CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .title(createProductRestModel.getTitle())
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .productId(UUID.randomUUID().toString()).build();

        String returnedValue = null;

        try {
            returnedValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnedValue = e.getLocalizedMessage();
        }

        return returnedValue;
    }

}
