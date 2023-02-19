package org.qmacias.products.service.rest;

import org.qmacias.products.service.rest.model.CreateProductRestModel;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
final class ProductsController {

    private final Environment env;

    ProductsController(final Environment env) {
        this.env = env;
    }

    @PostMapping
    public String createProduct(@RequestBody final CreateProductRestModel createProductRestModel) {
        return "HTTP POST Handled " + createProductRestModel.getTitle();
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
