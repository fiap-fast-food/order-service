package com.guilherme.fiapfood.api.request;

import com.guilherme.fiapfood.client.product.CategoryDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderProductRequestDTO {
    private String productId;
    private String name;
    private BigDecimal price;
    private String information;
    private CategoryDTO category;
}
