package com.example.ingresspaymentproject.service;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ExpensesService {
    public void saveExpenses(ExpensesDto expensesDto) ;
    public void updateExpenses(Long id,ExpensesDto expensesDto) ;
    public List<ExpensesDto> getAllExpenses();
}
