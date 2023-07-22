package com.example.ingresspaymentproject.service.impl;

import com.example.ingresspaymentproject.dto.PaymentRequestDto;
import com.example.ingresspaymentproject.dto.PaymentResponseDto;
import com.example.ingresspaymentproject.entity.PaymentEntity;
import com.example.ingresspaymentproject.entity.StudentEntity;
import com.example.ingresspaymentproject.mapper.PaymentMapper;
import com.example.ingresspaymentproject.repository.PaymentRepository;
import com.example.ingresspaymentproject.repository.StudentRepository;
import com.example.ingresspaymentproject.service.PaymentService;
import com.example.ingresspaymentproject.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final StudentRepository studentRepository;
    @Override
    public void savePayment(PaymentRequestDto paymentRequestDto) throws IOException {
        PaymentEntity paymentEntity  = mapper.fromDto(paymentRequestDto);
        paymentEntity.setReciepImage(ImageUtil.compressImage(paymentRequestDto.getReciepImage().getBytes()));
        repository.save(paymentEntity);
    }

    @Override
    public void updatePayment(Long id, PaymentRequestDto paymentRequestDto) throws IOException {
        PaymentEntity paymentEntity = repository.getById(id);
        paymentEntity.setStudent(paymentRequestDto.getStudent());
        paymentEntity.setCourseName(paymentRequestDto.getCourseName());
        paymentEntity.setAmount(paymentRequestDto.getAmount());
        paymentEntity.setCourseMonth(paymentRequestDto.getCourseMonth());
        paymentEntity.setReceiptDate(paymentRequestDto.getReceiptDate());
        paymentEntity.setReciepImage(ImageUtil.compressImage(paymentRequestDto.getReciepImage().getBytes()));
        repository.save(paymentEntity);
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
        return mapper.toDtoList(repository.findAll()) ;
    }

    @Override
    public List<PaymentResponseDto> getPayment(String number) {
        StudentEntity entity = studentRepository.findByPhone(number);
        return mapper.toDtoList(repository.findAllByStudent(entity.getFirstName()+" "+entity.getLastName()));
    }


}