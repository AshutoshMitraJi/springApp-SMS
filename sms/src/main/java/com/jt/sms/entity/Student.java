package com.jt.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String studentId;

    @Positive
    @Min(100)
    private int roll;

    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @Email(message = "Please provide a valid email!")
    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    @PositiveOrZero
    // @Digits(integer=5, fraction=2)
    private double fees;

    @NotBlank
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Please provide a valid phone number!")
    private String phoneNumber;
}
