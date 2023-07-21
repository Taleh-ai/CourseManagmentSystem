package com.example.ingresspaymentproject.repository;

import com.example.ingresspaymentproject.entity.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesEntity ,Long> {
    ExpensesEntity getById(Long  id);
}
