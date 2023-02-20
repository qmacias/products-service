package org.qmacias.products.service.core.data.main;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity implements java.io.Serializable {

    private static final long serialVersionUID = -8556192033846189435L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;

    private BigDecimal price;

    private BigInteger quantity;

}
