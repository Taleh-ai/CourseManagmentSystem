package com.example.ingresspaymentproject.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Blob;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Long id;
    private String courseName;
    private int courseMonth;
    private String student;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;
}