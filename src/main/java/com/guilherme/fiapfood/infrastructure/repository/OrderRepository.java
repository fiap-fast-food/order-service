package com.guilherme.fiapfood.infrastructure.repository;

import com.guilherme.fiapfood.enums.OrderStatus;
import com.guilherme.fiapfood.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT o FROM OrderEntity o WHERE o.orderStatus = :status1 OR o.orderStatus = :status2")
    List<OrderEntity> findByOrderStatus(@Param("status1") OrderStatus status1, @Param("status2") OrderStatus status2);

    @Query("SELECT o FROM OrderEntity o WHERE o.orderStatus = :status")
    List<OrderEntity> findByOrderStatus(@Param("status") OrderStatus status);
}
