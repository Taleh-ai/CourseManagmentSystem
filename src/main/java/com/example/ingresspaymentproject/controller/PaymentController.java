package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.dto.PaymentDto;
import com.example.ingresspaymentproject.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

private final PaymentServiceImpl paymentService;
    @PostMapping("payment")
    public void addPayment(@RequestBody PaymentDto paymentDto) throws IOException {
        paymentService.savePayment(paymentDto);
    }

    @PutMapping("payment/{id}")
    public void updatePayment(@PathVariable Long id, @RequestBody  PaymentDto paymentDto){
        paymentService.updatePayment(id,paymentDto);
    }
    @GetMapping("payment")
    public List<PaymentDto> getAllExpenses(){
        return paymentService.getAllPayments();
    }

    @GetMapping("payment/{number}")
    public List<PaymentDto> getExpenses(@PathVariable String number){
        return paymentService.getPayment(number);
    }
}
