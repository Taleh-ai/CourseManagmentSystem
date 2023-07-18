package com.example.ingresspaymentproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Long id;
    @NotEmpty(message = "The first name should not be empty!")
    private String firstName;

    @NotEmpty(message = "The last name should not be empty!")
    private String lastName;

    @NotEmpty(message = "The phone number should not be empty!")
    @Pattern(regexp="^\\+994\\d{9}$", message="Invalid number format!")
    private String phone;

    @NotEmpty(message = "The email should not be empty!")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

}
