package com.example.shopapp.repositoties;

import com.example.shopapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // tim cac don hang cua 1 user nao do
    List<Order> findByUserId(Long userId);
}
