package com.example;
/*2026_02_26 DZ_5+group
Создать базу  данных People
создать в этой базе таблицу Person с полями:
        -id -  Целые числа (индентификатор)
-age -  Целые числа
-salary - Десятичные дробные числа
-passport  - Строки с фиксированной длиной (10 символов)
-address -  Строки с переменной длиной (до 200 символов)
-dateOfBirthday - Дата
-dateTimeCreate- Дата и время
-timeToLunch -  Время
letter- Текст большого объёма

Создать Dao для Person. Создать PullRequest.
Групповое задание.
Используя аннатации над классом и полями класса DTO создать универсальную реализацию DAO для crud операций,
используя рефлексию.*/

import com.example.person.dao.PersonDao;
import com.example.person.dao.PersonDaoImpl;
import com.example.person.dto.Person;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.example.person.Constants5.*;

public class App5DAO {
    public static void main(String[] args) throws SQLException {
        Integer rand = new Random().nextInt(NUMBER_FIVE);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        PersonDao personDao = new PersonDaoImpl();
        Person person1 = Person.builder()
                .age(DbUtils.arAge[rand])
                .salary(DbUtils.arSalary[rand])
                .passport(DbUtils.arPassport[rand])
                .address(DbUtils.arAddress[rand])
                .dateOfBirthday(LocalDate.parse(DbUtils.arDateOfBirth[rand]))
                .dateTimeCreate(LocalDateTime.now())
                .timeToLunch(LocalTime.parse(DbUtils.arTimeToLunch[rand], formatter))
                .letter(DbUtils.arLetter[rand])
                .build();

        //System.out.println(personDao.save(person1));

        //System.out.println(personDao.get(15L));

        Person personUpdate = Person.builder()
                .id(1L)
                .age(DbUtils.arAge[rand])
                .salary(DbUtils.arSalary[rand])
                .passport(DbUtils.arPassport[rand])
                .address(DbUtils.arAddress[rand])
                .dateOfBirthday(LocalDate.parse(DbUtils.arDateOfBirth[rand]))
                .dateTimeCreate(LocalDateTime.now())
                .timeToLunch(LocalTime.parse(DbUtils.arTimeToLunch[rand], formatter))
                .letter(UPDATE_SIGN)
                .build();

        personDao.update(personUpdate);
        System.out.println(personDao.get(1L));
    }
}
