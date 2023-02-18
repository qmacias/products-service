package org.qmacias.products.service.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
final class ProductsController {

    @PostMapping
    public String createProduct() {
        return "HTTP POST Handled";
    }

    @GetMapping
    public String getProduct() {
        return "HTTP GET Handled";
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
