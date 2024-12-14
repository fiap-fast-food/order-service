package com.guilherme.fiapfood.api.converter;

import com.guilherme.fiapfood.api.request.OrderRequestDTO;
import com.guilherme.fiapfood.api.response.OrderResponseDTO;
import com.guilherme.fiapfood.infrastructure.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "products", target = "products")
    OrderResponseDTO orderEntityToOrderResponse(OrderEntity order);

    OrderEntity orderRequestToOrder(OrderRequestDTO orderRequest);
}
