package com.example.payment_service.service;


import com.example.payment_service.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();
    PaymentDTO savePayment(PaymentDTO paymentDTO);
    void updatePayment(PaymentDTO paymentDTO);
    void deletePayment(PaymentDTO paymentDTO);
    PaymentDTO findPaymentById(String id);
}
