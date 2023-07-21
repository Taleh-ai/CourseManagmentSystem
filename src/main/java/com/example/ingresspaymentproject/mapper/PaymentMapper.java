package com.example.ingresspaymentproject.mapper;

import com.example.ingresspaymentproject.dto.PaymentRequestDto;
import com.example.ingresspaymentproject.dto.PaymentResponseDto;
import com.example.ingresspaymentproject.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class PaymentMapper {
    public PaymentEntity fromDto(PaymentRequestDto paymentRequestDto) throws IOException {
        PaymentEntity entity = PaymentEntity.builder()
                .amount(paymentRequestDto.getAmount())
                .courseName(paymentRequestDto.getCourseName())
                .courseMonth(paymentRequestDto.getCourseMonth())
                .student(paymentRequestDto.getStudent())
                .receiptDate(paymentRequestDto.getReceiptDate())
                .reciepImage(null)
                .build();
        return entity;
    }

    public List<PaymentEntity> fromDtoList(List<PaymentRequestDto> paymentRequestDtoList){
        PaymentMapper mapper = new PaymentMapper();
        return paymentRequestDtoList.stream().map(n-> {
            try {
                return mapper.fromDto(n);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

    }
    public PaymentResponseDto toDto(PaymentEntity paymentEntity){
        PaymentResponseDto paymentResponseDto = PaymentResponseDto.builder()
                .amount(paymentEntity.getAmount())
                .courseName(paymentEntity.getCourseName())
                .courseMonth(paymentEntity.getCourseMonth())
                .student(paymentEntity.getStudent())
                .receiptDate(paymentEntity.getReceiptDate())
                .id(paymentEntity.getId())
                .reciepImage(paymentEntity.getReciepImage())
                .build();
        return paymentResponseDto;
    }

    public List<PaymentResponseDto> toDtoList(List<PaymentEntity> paymentEntityList){
        PaymentMapper mapper = new PaymentMapper();
        return paymentEntityList.stream().map(n->mapper.toDto(n)).collect(Collectors.toList());

    }

}
