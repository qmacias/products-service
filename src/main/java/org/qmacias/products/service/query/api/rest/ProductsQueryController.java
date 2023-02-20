package org.qmacias.products.service.query.api.rest;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;

import org.qmacias.products.service.query.application.FindAllProductsQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
final class ProductsQueryController {

    final QueryGateway queryGateway;

    ProductsQueryController(final QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getProducts() {
        FindAllProductsQuery findAllProductsQuery = new FindAllProductsQuery();

        return queryGateway.query(findAllProductsQuery,
                ResponseTypes.multipleInstancesOf(ProductRestModel.class)
        ).join();
    }

}
