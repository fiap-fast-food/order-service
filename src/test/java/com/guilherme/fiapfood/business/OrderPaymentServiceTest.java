package com.guilherme.fiapfood.business;

import com.guilherme.fiapfood.client.payment.PaymentClient;
import com.guilherme.fiapfood.client.payment.PaymentRequestDTO;
import com.guilherme.fiapfood.client.payment.PaymentResponseDTO;
import com.guilherme.fiapfood.utils.OrderHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class OrderPaymentServiceTest {

    @Mock
    private OrderService orderService;
    @Mock
    private PaymentClient paymentClient;

    private OrderPaymentService orderPaymentService;
    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        orderPaymentService = new OrderPaymentService(
                orderService,
                paymentClient
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    void mustAllowCreatePayment() {

        // Arrange
        var order = OrderHelper.gerarOrderEntity();
        var orderResponse = OrderHelper.gerarOrderResponse();
        order.setId(1L);

        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.setInitPoint("teste");

        when(orderService.getOrderById(1L)).thenReturn(orderResponse);
        when(paymentClient.createPayment(any(PaymentRequestDTO.class))).thenReturn(paymentResponseDTO);


        // Act
        var orderPaymentRegistred = orderPaymentService.createPayment(1L);

        // Assert
        assertThat(orderPaymentRegistred).isInstanceOf(PaymentResponseDTO.class).isNotNull();
    }

}