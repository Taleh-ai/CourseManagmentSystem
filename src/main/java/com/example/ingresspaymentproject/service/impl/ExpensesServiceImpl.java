package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.ExpensesRequestDto;
import com.example.ingresspaymentproject.dto.ExpensesResponseDto;
import com.example.ingresspaymentproject.entity.ExpensesEntity;
import com.example.ingresspaymentproject.mapper.ExpensesMapper;
import com.example.ingresspaymentproject.repository.ExpensesRepository;
import com.example.ingresspaymentproject.service.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {
    private final ExpensesRepository repository;
    private final ExpensesMapper mapper;

    @Override
    public void saveExpenses(ExpensesRequestDto expensesRequestDto) throws IOException {

        ExpensesEntity expensesEntity  = mapper.fromDto(expensesRequestDto);
        expensesEntity.setReciepImage(expensesRequestDto.getReciepImage().getBytes());
        repository.save(expensesEntity);
    }

    @Override
    public void updateExpenses(Long id, ExpensesRequestDto expensesRequestDto) throws IOException {
        ExpensesEntity expensesEntity = repository.getById(id);
        expensesEntity.setExpensesName(expensesRequestDto.getExpensesName());
        expensesEntity.setDescription(expensesRequestDto.getDescription());
        expensesEntity.setAmount(expensesRequestDto.getAmount());
        expensesEntity.setExpensesDate(expensesRequestDto.getExpensesDate());
        expensesEntity.setReciepImage(expensesRequestDto.getReciepImage().getBytes());
        repository.save(expensesEntity);
    }

    @Override
    public List<ExpensesResponseDto> getAllExpenses() {
        List<ExpensesEntity> expensesEntityList= repository.findAll();
        return mapper.toDtoList(expensesEntityList);
    }


}
