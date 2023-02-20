package org.qmacias.products.service.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_LOOKUP")
public class ProductLookupEntity implements java.io.Serializable {

    private static final long serialVersionUID = -5434686797467647524L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;

}
