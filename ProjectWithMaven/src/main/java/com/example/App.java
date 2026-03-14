/*2026_02_26
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
Добавить 5 произвольных Person использовать JDBC
Выбрать из этой таблици всех  Person у котороых age > 21, и отсортировать эту выборку по полю  dateTimeCreate использовать JDBC.
Используя JDBC вывести метаданные по базе данных (таблице People, колнки, тип колонок, название колонок..) на экран
создать PullRequest.*/
package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.DbUtils.*;
import static java.time.LocalTime.now;

public class App {
    public static void main(String[] args) throws SQLException {
        //printMetaData();
        //printDataDescSalary();
        addFivePersons();
    }
}
