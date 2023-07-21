package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.dto.PaymentDto;
import com.example.ingresspaymentproject.entity.PaymentEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PaymentService {

    public void savePayment(PaymentDto paymentDto);
    public void updatePayment(Long id,PaymentDto paymentDto);
    public List<PaymentDto> getAllPayments();
    public List<PaymentDto> getPayment(String number);

}
