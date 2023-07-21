package com.example.ingresspaymentproject.dto;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensesDto {
    private Long id;
    private String expensesName;
    private String description;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expensesDate;

}