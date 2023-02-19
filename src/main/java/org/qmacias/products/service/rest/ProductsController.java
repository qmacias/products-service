package org.qmacias.products.service.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.qmacias.products.service.application.cmd.CreateProductCommand;
import org.qmacias.products.service.rest.model.CreateProductRestModel;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
final class ProductsController {

    final Environment env;

    final CommandGateway commandGateway;

    ProductsController(final Environment env, final CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody final CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .title(createProductRestModel.getTitle())
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

    @GetMapping
    public String getProduct() {
        return "HTTP GET Handled at port "
                + env.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP PUT Handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE Handled";
    }

}
