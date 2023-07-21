package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.ExpensesRequestDto;
import com.example.ingresspaymentproject.dto.ExpensesResponseDto;

import java.io.IOException;
import java.util.List;

public interface ExpensesService {
    public void saveExpenses(ExpensesRequestDto expensesRequestDto) throws IOException;
    public void updateExpenses(Long id, ExpensesRequestDto expensesRequestDto) throws IOException;
    public List<ExpensesResponseDto> getAllExpenses();
}
