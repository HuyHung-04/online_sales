package com.example.shopapp.repositoties;

import com.example.shopapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // kiem tra user co so dien thoai nay co ton tai huy khong
    boolean existsByPhoneNumber(String phoneNumber);
    // kiem tra ket qua bang null hay khac null
    Optional<User> findByPhoneNumber(String phoneNumber);
}
