package com.example.ingresspaymentproject.controller;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.service.impl.ExpensesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpensesController {
    private  final ExpensesServiceImpl expensesService;
    @PostMapping("expenses")
    public void addExpenses(@RequestBody  ExpensesDto expensesDto){
        expensesService.saveExpenses(expensesDto);
    }

    @PutMapping("expenses/{id}")
    public void updateExpenses(@PathVariable Long id, @RequestBody  ExpensesDto expensesDto)  {
        expensesService.updateExpenses(id,expensesDto);
    }
    @GetMapping("expenses")
    public List<ExpensesDto> getAllExpenses(){
       return expensesService.getAllExpenses();
    }
}
