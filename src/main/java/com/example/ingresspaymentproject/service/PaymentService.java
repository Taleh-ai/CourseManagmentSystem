package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.PaymentRequestDto;
import com.example.ingresspaymentproject.dto.PaymentResponseDto;

import java.io.IOException;
import java.util.List;

public interface PaymentService {

    public void savePayment(PaymentRequestDto paymentRequestDto) throws IOException;
    public void updatePayment(Long id, PaymentRequestDto paymentRequestDto) throws IOException;
    public List<PaymentResponseDto> getAllPayments();
    public List<PaymentResponseDto> getPayment(String number);

}
