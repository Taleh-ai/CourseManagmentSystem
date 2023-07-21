package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.entity.ExpensesEntity;
import com.example.ingresspaymentproject.mapper.ExpensesMapper;
import com.example.ingresspaymentproject.repository.ExpensesRepository;
import com.example.ingresspaymentproject.service.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {
    private final ExpensesRepository repository;
    private final ExpensesMapper mapper;

    @Override
    public void saveExpenses(ExpensesDto expensesDto)  {

        ExpensesEntity expensesEntity  = mapper.fromDto(expensesDto);
        repository.save(expensesEntity);
    }

    @Override
    public void updateExpenses(Long id,ExpensesDto expensesDto)  {
        ExpensesEntity expensesEntity = repository.getById(id);
        expensesEntity.setExpensesName(expensesDto.getExpensesName());
        expensesEntity.setDescription(expensesDto.getDescription());
        expensesEntity.setAmount(expensesDto.getAmount());
        expensesEntity.setExpensesDate(expensesDto.getExpensesDate());

        repository.save(expensesEntity);
    }

    @Override
    public List<ExpensesDto> getAllExpenses() {
        List<ExpensesEntity> expensesEntityList= repository.findAll();
        return mapper.toDtoList(expensesEntityList);
    }


}
