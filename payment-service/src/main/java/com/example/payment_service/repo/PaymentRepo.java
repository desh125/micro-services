package com.example.payment_service.repo;

import com.example.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepo extends JpaRepository<Payment, String> {
}
