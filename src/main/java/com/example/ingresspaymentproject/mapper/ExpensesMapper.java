package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.ExpensesRequestDto;
import com.example.ingresspaymentproject.dto.ExpensesResponseDto;
import com.example.ingresspaymentproject.entity.ExpensesEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class ExpensesMapper {
    public ExpensesEntity fromDto(ExpensesRequestDto expensesRequestDto){
        ExpensesEntity entity = ExpensesEntity.builder()
                .amount(expensesRequestDto.getAmount())
                .description(expensesRequestDto.getDescription())
                .expensesDate(expensesRequestDto.getExpensesDate())
                .expensesName(expensesRequestDto.getExpensesName())
                .build();
        return entity;
    }

    public List<ExpensesEntity> fromDtoList(List<ExpensesRequestDto> expensesRequestDtoList){
        ExpensesMapper mapper = new ExpensesMapper();
        return expensesRequestDtoList.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public ExpensesResponseDto toDto(ExpensesEntity expensesEntity){
        ExpensesResponseDto expensesResponseDto = ExpensesResponseDto.builder()
                .amount(expensesEntity.getAmount())
                .description(expensesEntity.getDescription())
                .expensesDate(expensesEntity.getExpensesDate())
                .expensesName(expensesEntity.getExpensesName())
                .id(expensesEntity.getId())
                .reciepImage(expensesEntity.getReciepImage())
                .build();
        return expensesResponseDto;
    }

    public List<ExpensesResponseDto> toDtoList(List<ExpensesEntity> expensesEntityList){
        ExpensesMapper mapper = new ExpensesMapper();
        return expensesEntityList.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }
}
