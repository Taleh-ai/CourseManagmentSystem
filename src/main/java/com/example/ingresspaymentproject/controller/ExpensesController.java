package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.ExpensesRequestDto;
import com.example.ingresspaymentproject.dto.ExpensesResponseDto;
import com.example.ingresspaymentproject.service.impl.ExpensesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpensesController {
    private  final ExpensesServiceImpl expensesService;
    @PostMapping(value = "expenses" ,consumes = {"multipart/form-data"},produces = "application/json")
    public void addExpenses(@ModelAttribute ExpensesRequestDto expensesRequestDto) throws IOException {
        expensesService.saveExpenses(expensesRequestDto);
    }

    @PutMapping(value = "expenses/{id}",consumes = {"multipart/form-data"},produces = "application/json")
    public void updateExpenses(@PathVariable Long id, @ModelAttribute ExpensesRequestDto expensesRequestDto) throws IOException {
        expensesService.updateExpenses(id, expensesRequestDto);
    }
    @GetMapping("expenses")
    public List<ExpensesResponseDto> getAllExpenses(){
       return expensesService.getAllExpenses();
    }
}
