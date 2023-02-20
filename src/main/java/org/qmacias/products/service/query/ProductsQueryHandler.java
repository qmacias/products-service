package org.qmacias.products.service.query;

import org.axonframework.queryhandling.QueryHandler;

import org.qmacias.products.service.core.data.main.ProductEntity;
import org.qmacias.products.service.core.data.main.ProductRepository;
import org.qmacias.products.service.query.api.rest.ProductRestModel;
import org.qmacias.products.service.query.application.FindAllProductsQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsQueryHandler {

    final ProductRepository productRepository;

    public ProductsQueryHandler(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(final FindAllProductsQuery query) {
        List<ProductEntity> productEntityEntities = productRepository.findAll();

        return productEntityEntities.stream().map(productEntity -> {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            return productRestModel;
        }).collect(Collectors.toList());
    }

}
