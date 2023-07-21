package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.PaymentDto;
import com.example.ingresspaymentproject.entity.PaymentEntity;
import com.example.ingresspaymentproject.mapper.PaymentMapper;
import com.example.ingresspaymentproject.repository.PaymentRepository;
import com.example.ingresspaymentproject.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    @Override
    public void savePayment(PaymentDto paymentDto)  {
        PaymentEntity paymentEntity  = mapper.fromDto(paymentDto);

        repository.save(paymentEntity);
    }

    @Override
    public void updatePayment(Long id, PaymentDto paymentDto) {
        PaymentEntity paymentEntity = repository.getById(id);
        paymentEntity.setStudent(paymentDto.getStudent());
        paymentEntity.setCourseName(paymentDto.getCourseName());
        paymentEntity.setAmount(paymentDto.getAmount());
        paymentEntity.setCourseMonth(paymentDto.getCourseMonth());
        paymentEntity.setReceiptDate(paymentDto.getReceiptDate());
        repository.save(paymentEntity);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        return mapper.toDtoList(repository.findAll()) ;
    }

    @Override
    public List<PaymentDto> getPayment(String number) {
     return mapper.toDtoList(repository.findAllByStudent(number));
    }


}
