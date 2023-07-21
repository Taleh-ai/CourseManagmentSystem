package com.example.ingresspaymentproject.dto;
import jakarta.persistence.Lob;
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
public class PaymentRequestDto {
    private Long id;
    private String courseName;
    private int courseMonth;
    private String student;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;
    private MultipartFile reciepImage;
}