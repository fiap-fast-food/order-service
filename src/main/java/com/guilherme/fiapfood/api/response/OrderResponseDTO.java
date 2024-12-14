package com.guilherme.fiapfood.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.guilherme.fiapfood.api.request.CustomerRequestDTO;
import com.guilherme.fiapfood.api.request.PaymentOrderDTO;
import com.guilherme.fiapfood.client.product.OrderProductResponseDTO;
import com.guilherme.fiapfood.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseDTO {

    private Long id;
    private CustomerRequestDTO customer;
    private List<OrderProductResponseDTO> products;
    private LocalDateTime dateTimeOrder;
    private PaymentOrderDTO payment;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
}
