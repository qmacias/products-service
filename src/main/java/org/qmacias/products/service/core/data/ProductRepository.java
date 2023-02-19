package org.qmacias.products.service.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    ProductEntity findByProductId(final String productId);

    ProductEntity findByProductIdOrTitle(final String productId, final String title);

}
