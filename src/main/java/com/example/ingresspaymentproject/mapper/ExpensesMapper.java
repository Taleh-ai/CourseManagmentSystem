package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.entity.ExpensesEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class ExpensesMapper {
    public ExpensesEntity fromDto(ExpensesDto expensesDto){
        ExpensesEntity entity = ExpensesEntity.builder()
                .amount(expensesDto.getAmount())
                .description(expensesDto.getDescription())
                .expensesDate(expensesDto.getExpensesDate())
                .expensesName(expensesDto.getExpensesName())
                .build();
        return entity;
    }

    public List<ExpensesEntity> fromDtoList(List<ExpensesDto> expensesDtoList){
        ExpensesMapper mapper = new ExpensesMapper();
        return expensesDtoList.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public ExpensesDto toDto(ExpensesEntity expensesEntity){
        ExpensesDto expensesDto = ExpensesDto.builder()
                .amount(expensesEntity.getAmount())
                .description(expensesEntity.getDescription())
                .expensesDate(expensesEntity.getExpensesDate())
                .expensesName(expensesEntity.getExpensesName())
                .id(expensesEntity.getId())
                .build();
        return expensesDto;
    }

    public List<ExpensesDto> toDtoList(List<ExpensesEntity> expensesEntityList){
        ExpensesMapper mapper = new ExpensesMapper();
        return expensesEntityList.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }
}
