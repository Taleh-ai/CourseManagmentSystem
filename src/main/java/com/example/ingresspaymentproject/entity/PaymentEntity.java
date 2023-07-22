package com.example.ingresspaymentproject.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "payments")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String courseName;
  private int courseMonth;
  private int amount;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate receiptDate;
  private String student;

  @Lob
  @JdbcTypeCode(Types.LONGVARBINARY)
  private byte[] reciepImage;
}
