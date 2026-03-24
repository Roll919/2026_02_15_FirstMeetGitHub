package com.example.person;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Constants5 {
    String SQL_ADD_PERSON = "INSERT INTO person (age, salary, passport, address, dateOfBirthday," +
            " dateTimeCreate, timeToLunch, letter) VALUES(?,?,?,?,?,now(),?,?)";
    String SQL_GET_PERSON = "SELECT * FROM people.person WHERE id = ?";
    String SQL_UPDATE_PERSON = "UPDATE people.person SET age = ?, salary = ?, passport = ?, address = ?," +
            " dateOfBirthday = ?, dateTimeCreate = ?, timeToLunch = ?, letter = ? WHERE id = ?";
    String SQL_DELETE_PERSON = "DELETE FROM people.person WHERE id = ?";
    Integer NUMBER_ONE = 1;
    Integer NUMBER_FIVE = 5;
    String UPDATE_SIGN = "обновленная персона";

}
