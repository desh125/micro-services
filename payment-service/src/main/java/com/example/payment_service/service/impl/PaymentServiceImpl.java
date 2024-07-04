package com.example.payment_service.service.impl;

import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repo.PaymentRepo;
import com.example.payment_service.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public PaymentServiceImpl(PaymentRepo paymentRepo, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.paymentRepo = paymentRepo;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        Payment savedPayment = paymentRepo.save(payment);

        String ticketServiceUrl = "http://TICKET-SERVICE/api/v0/ticket/" + paymentDTO.getTicketId() + "/"+"Paid";
        restTemplate.put(ticketServiceUrl, null);

        return modelMapper.map(savedPayment, PaymentDTO.class);
    }


    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        paymentRepo.save(payment);
    }

    @Override
    public void deletePayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        paymentRepo.delete(payment);
    }

    @Override
    public PaymentDTO findPaymentById(String id) {
        Payment payment = paymentRepo.findById(id).orElse(null);
        if (payment != null) {
            return modelMapper.map(payment, PaymentDTO.class);
        }
        return null;
    }
}
