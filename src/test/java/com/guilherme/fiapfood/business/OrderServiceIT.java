package com.guilherme.fiapfood.business;

import com.guilherme.fiapfood.api.converter.OrderMapper;
import com.guilherme.fiapfood.api.response.OrderResponseDTO;
import com.guilherme.fiapfood.client.product.ProductClient;
import com.guilherme.fiapfood.infrastructure.exceptions.NotFoundException;
import com.guilherme.fiapfood.infrastructure.repository.OrderRepository;
import com.guilherme.fiapfood.utils.OrderHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
@ActiveProfiles("test")
class OrderServiceIT {

    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;


    @Test
    @Severity(SeverityLevel.BLOCKER)
    void mustAllowRegisterOrder() {

        // Arrange
        var order = OrderHelper.gerarOrderRequestDTO();

        // Act
        var orderRegistred = orderService.createOrder(order);

        // Assert
        assertThat(orderRegistred).isInstanceOf(OrderResponseDTO.class).isNotNull();
        assertThat(orderRegistred.getProducts()).isNotNull();
        assertThat(orderRegistred.getDateTimeOrder()).isNotNull();
        assertThat(orderRegistred.getTotalAmount()).isNotNull();
    }

    @Test
    void mustAllowFindOrder() throws NotFoundException {

        // Act
        var orderReceived = orderService.getOrderById(1L);

        // Assert
        Assertions.assertThat(orderReceived.getId()).isNotNull();
        Assertions.assertThat(orderReceived.getTotalAmount()).isNotNull();
        Assertions.assertThat(orderReceived.getProducts()).isNotNull();
    }

    @Test
    void mustGenerateExceptionWhenIdDoesNotExist() {
        assertThatThrownBy(() -> orderService.getOrderById(54L))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Order not found");
    }

    @Test
    void mustAllowListOrders() {

        // Act
        var productsReceived = orderService.getAllOrders();

        // Assert
        Assertions.assertThat(productsReceived).isNotEmpty();
    }


}