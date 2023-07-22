package com.example.ingresspaymentproject.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensesRequestDto {

    private String expensesName;
    private String description;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expensesDate;
    private MultipartFile reciepImage;

}