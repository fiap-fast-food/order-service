package com.guilherme.fiapfood.utils;


import com.guilherme.fiapfood.api.request.CustomerRequestDTO;
import com.guilherme.fiapfood.api.request.OrderRequestDTO;
import com.guilherme.fiapfood.api.response.OrderResponseDTO;
import com.guilherme.fiapfood.client.product.CategoryDTO;
import com.guilherme.fiapfood.client.product.OrderProductResponseDTO;
import com.guilherme.fiapfood.client.product.Product;
import com.guilherme.fiapfood.infrastructure.entity.CustomerEntity;
import com.guilherme.fiapfood.infrastructure.entity.OrderEntity;
import com.guilherme.fiapfood.infrastructure.entity.OrderProductEntity;
import com.guilherme.fiapfood.infrastructure.entity.PaymentOrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderHelper {

    public static OrderEntity gerarOrderEntity() {
        return OrderEntity.builder()
                .id(1L)
                .customer(gerarCustomerEntity())
                .dateTimeOrder(LocalDateTime.now())
                .payment(gerarPaymentEntity())
                .products(List.of(gerarProductEntity()))
                .totalAmount(new BigDecimal("30.0"))
                .build();
    }

    public static OrderRequestDTO gerarOrderRequestDTO() {
        return OrderRequestDTO.builder()
                .customer(gerarCustomerRequestDTO())
                .productsId(List.of("19761bff-a379-45dd-8db5-7b4670f7e0b9"))
                .build();
    }

    public static CustomerRequestDTO gerarCustomerRequestDTO() {
        return CustomerRequestDTO.builder()
                .name("Teste")
                .cpf("11111111111")
                .build();
    }

    public static CustomerEntity gerarCustomerEntity() {
        return CustomerEntity.builder()
                .name("Teste")
                .build();
    }

    public static PaymentOrderEntity gerarPaymentEntity() {
        return PaymentOrderEntity.builder()
                .id(1L)
                .status("PENDING")
                .amount(new BigDecimal("33.0"))
                .build();
    }
    public static OrderProductEntity gerarProductEntity() {
        return OrderProductEntity.builder()
                .productId("a0d94841-8ac4-4346-af6d-dbb82bd316cc")
                .price(new BigDecimal("12.0"))
                .information("Information")
                .name("Hamburguer")
                .build();
    }

    public static Product gerarProduct() {
        Product product = new Product("a0d94841-8ac4-4346-af6d-dbb82bd316cc",
                "Hamburguer",
                new BigDecimal("12.0"),
                "Information",
                new CategoryDTO("Hambúrguers"));
        return product;
    }

    public static OrderResponseDTO gerarOrderResponse() {
        return OrderResponseDTO.builder()
                .dateTimeOrder(gerarOrderEntity().getDateTimeOrder())
                .customer(gerarCustomerRequestDTO())
                .id(gerarOrderEntity().getId())
                .products(List.of(gerarOrderProductResponseDTO()))
                .build();
    }

    public static OrderProductResponseDTO gerarOrderProductResponseDTO() {
        return OrderProductResponseDTO.builder()
                .productId("teste")
                .category("teste")
                .price(new BigDecimal("10.0"))
                .information("teste")
                .name("teste")
                .build();
    }
}
