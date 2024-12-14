package com.guilherme.fiapfood.api.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderRequestDTO {

    private CustomerRequestDTO customer;
    private List<String> productsId;
}
