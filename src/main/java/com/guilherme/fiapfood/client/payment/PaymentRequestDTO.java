package com.guilherme.fiapfood.client.payment;

import com.guilherme.fiapfood.api.request.CustomerRequestDTO;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PaymentRequestDTO {
    private Long idOrder;
    private List<PaymentProductRequestDTO> products;

    private CustomerRequestDTO customer;

}
