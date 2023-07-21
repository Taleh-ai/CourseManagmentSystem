package com.example.ingresspaymentproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
  @Table(name = "expenses")
public class ExpensesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(name = "expenses_name")
  private String expensesName;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private int amount;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "expenses_date")
  private LocalDate expensesDate;
  @Lob
  private byte[] reciepImage;
}
