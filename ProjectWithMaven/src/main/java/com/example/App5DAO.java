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
import java.util.Random;

public class App5DAO {
    public static void main(String[] args) throws SQLException {
        Integer rand = new Random().nextInt(5);
        PersonDao personDao = new PersonDaoImpl();
        Person person1 = Person.builder()
                .age(DbUtils.arAge[rand])
                .salary(DbUtils.arSalary[rand])
                .build();
        personDao.save(person1);
    }
}
