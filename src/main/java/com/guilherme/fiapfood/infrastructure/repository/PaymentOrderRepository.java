package com.guilherme.fiapfood.infrastructure.repository;

import com.guilherme.fiapfood.infrastructure.entity.PaymentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrderEntity, Long> {
}
