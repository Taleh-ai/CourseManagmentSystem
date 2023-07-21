package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.PaymentRequestDto;
import com.example.ingresspaymentproject.dto.PaymentResponseDto;
import com.example.ingresspaymentproject.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    @PostMapping(value = "payment",consumes = {"multipart/form-data"},produces = "application/json")
    public void addPayment(@ModelAttribute PaymentRequestDto paymentRequestDto) throws IOException {
        paymentService.savePayment(paymentRequestDto);
    }

    @PutMapping(value = "payment/{id}",consumes = {"multipart/form-data"},produces = "application/json")
    public void updatePayment(@PathVariable Long id, @ModelAttribute PaymentRequestDto paymentRequestDto) throws IOException {
        paymentService.updatePayment(id, paymentRequestDto);
    }
    @GetMapping("payment")
    public List<PaymentResponseDto> getAllExpenses(){
        return paymentService.getAllPayments();
    }

    @GetMapping("payment/{number}")
    public List<PaymentResponseDto> getExpenses(@PathVariable String number){
        return paymentService.getPayment(number);
    }
}