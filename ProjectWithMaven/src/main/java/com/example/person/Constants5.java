package com.example.person;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Constants5 {
    String SQL_ADD_PERSON = "INSERT INTO person (age, salary, passport, address, dateOfBirthday," +
            " dateTimeCreate, timeToLunch, letter) VALUES(?,?,?,?,?,now(),?,?)";

}
