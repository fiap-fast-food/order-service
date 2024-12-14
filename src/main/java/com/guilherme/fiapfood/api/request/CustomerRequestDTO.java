package com.guilherme.fiapfood.api.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CustomerRequestDTO {
    private String name;
    private String cpf;
    private String email;
}
