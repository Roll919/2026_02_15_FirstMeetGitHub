package com.example.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person {
    private int id;
    private int age;
    private int salary;
    private String passport;
    private String address;
    private LocalDate dateOfBirthday;
    private LocalDateTime dateTimeCreate;
    private LocalDateTime timeToLunch;
    private String letter;
}

