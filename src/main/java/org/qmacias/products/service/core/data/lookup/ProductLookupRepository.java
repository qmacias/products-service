package org.qmacias.products.service.core.data.lookup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookupEntity, String> {

    ProductLookupEntity findByTitle(final String title); // TODO: for create command interceptor validation

    ProductLookupEntity findByProductId(final String productId); // TODO: for update command interceptor validation

    ProductLookupEntity findByProductIdOrTitle(final String productId, final String title);

}
