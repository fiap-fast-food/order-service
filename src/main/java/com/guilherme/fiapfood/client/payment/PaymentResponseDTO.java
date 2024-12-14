package com.guilherme.fiapfood.client.payment;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PaymentResponseDTO {
    private String initPoint;
}
