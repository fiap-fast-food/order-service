package com.guilherme.fiapfood.business;

import com.guilherme.fiapfood.api.response.OrderResponseDTO;
import com.guilherme.fiapfood.client.payment.PaymentClient;
import com.guilherme.fiapfood.client.payment.PaymentProductRequestDTO;
import com.guilherme.fiapfood.client.payment.PaymentRequestDTO;
import com.guilherme.fiapfood.client.payment.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPaymentService {

    private final OrderService orderService;
    private final PaymentClient paymentClient;


    public PaymentResponseDTO createPayment(Long idOrder) {

        OrderResponseDTO orderById = orderService.getOrderById(idOrder);

        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setCustomer(orderById.getCustomer());
        paymentRequestDTO.setIdOrder(idOrder);

        List<PaymentProductRequestDTO> paymentProductRequestList = new ArrayList<>();

        orderById.getProducts().forEach(productsByOrderId -> {

            PaymentProductRequestDTO productRequestDTO = new PaymentProductRequestDTO();

            productRequestDTO.setProductId(productRequestDTO.getProductId());
            productRequestDTO.setProductName(productsByOrderId.getName());
            productRequestDTO.setProductDescription(productsByOrderId.getInformation());
            productRequestDTO.setCategoryProduct(productsByOrderId.getCategory());
            productRequestDTO.setQuantityProduct(1);
            productRequestDTO.setProductPrice(productsByOrderId.getPrice());
            paymentProductRequestList.add(productRequestDTO);
        });
        paymentRequestDTO.setProducts(paymentProductRequestList);

        return paymentClient.createPayment(paymentRequestDTO);
    }
}
