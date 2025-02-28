package com.example.shopapp.repositoties;

import com.example.shopapp.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // kien tra xem ten co ton tai
    boolean existsByName(String name);
    // phan trang
    Page<Product> findAll(Pageable pageable);
}
