package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.ExpensesDto;
import com.example.ingresspaymentproject.dto.PaymentDto;
import com.example.ingresspaymentproject.entity.ExpensesEntity;
import com.example.ingresspaymentproject.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class PaymentMapper {
    public PaymentEntity fromDto(PaymentDto paymentDto){
        PaymentEntity entity = PaymentEntity.builder()
                .amount(paymentDto.getAmount())
                .courseName(paymentDto.getCourseName())
                .courseMonth(paymentDto.getCourseMonth())
                .student(paymentDto.getStudent())
                .receiptDate(paymentDto.getReceiptDate())
                .reciepImage(null)
                .build();
        return entity;
    }

    public List<PaymentEntity> fromDtoList(List<PaymentDto> paymentDtoList){
        PaymentMapper mapper = new PaymentMapper();
        return paymentDtoList.stream().map(n->mapper.fromDto(n)).collect(Collectors.toList());

    }
    public PaymentDto toDto(PaymentEntity paymentEntity){
        PaymentDto paymentDto = PaymentDto.builder()
                .amount(paymentEntity.getAmount())
                .courseName(paymentEntity.getCourseName())
                .courseMonth(paymentEntity.getCourseMonth())
                .student(paymentEntity.getStudent())
                .receiptDate(paymentEntity.getReceiptDate())
                .id(paymentEntity.getId())
               // .reciepImage(paymentEntity.getReciepImage())
                .build();
        return paymentDto;
    }

    public List<PaymentDto> toDtoList(List<PaymentEntity> paymentEntityList){
        PaymentMapper mapper = new PaymentMapper();
        return paymentEntityList.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }

}
