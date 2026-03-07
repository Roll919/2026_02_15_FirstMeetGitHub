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

public class App {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                "root", "***")) {
            DatabaseMetaData metaData = conn.getMetaData();
            String[] table = {"TABLE"};
            System.out.println(metaData);
            List tablesList = new ArrayList();
            try (ResultSet rs = metaData.getTables("people", null, null,
                    table)) {
                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    String tableName1 = rs.getString(5);//то же, что и выше строка только капсом выведет
                    tablesList.add(tableName);
                    System.out.println(tableName.toUpperCase() + tableName1);
                    try (ResultSet rsColumn = metaData.getColumns("people", null, tableName,
                            null)) {
                        System.out.println(tableName.toUpperCase());
                        while (rsColumn.next()) {
                            System.out.println(rsColumn.getString("COLUMN_NAME") + " "
                                    + rsColumn.getString("TYPE_NAME") + " "
                                    + rsColumn.getString("COLUMN_SIZE"));
                        }
                    }
                }

            }
        }
    }
}
