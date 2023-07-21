package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
List<PaymentEntity> findAllByStudent(String number);
}
