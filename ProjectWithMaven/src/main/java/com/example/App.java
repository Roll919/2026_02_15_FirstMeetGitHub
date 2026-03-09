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

import static java.time.LocalTime.now;

public class App {
    public static void main(String[] args) throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("DB_people");
        String url = resource.getString("url");
        String userName = resource.getString("user");//чуть ниже ввеле
        String pass = resource.getString("password");
        try (Connection conn = DriverManager.getConnection(url, userName, pass);
             Statement st = conn.createStatement()) {
            //    printMetaData(conn);
            try (ResultSet rs = st.executeQuery("SELECT * FROM person")) {//работа с данными
                ResultSetMetaData rsmd = rs.getMetaData();//работа со структурой
                int number = rsmd.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= number; i++) {
                        String columnName = rsmd.getColumnName(i);
                        System.out.print(columnName + " " + rs.getString(i) + " ");
                        // System.out.print(" " + rs.getString(i));//доставать через индекс
                        //  System.out.println(" " + rs.getString(columnName));//доставать через имя колонки
                    }
                    System.out.println();
                }
            }
            //addFivePersons(st);

        }
    }

    private static void addFivePersons(Statement st) throws SQLException {
        st.executeUpdate("INSERT INTO person (age, salary, passport, addres, dateOfBirthday, dateTimeCreate, timeToLunch, letter) VALUES" +
         "(22, 11000, 'MP135236', 'st_Pobedy5', '2005-01-02', now(), '131500', 'шестой пошел')," +
         "(32, 21000, 'MP235236', 'st_Pobedy6', '1995-01-02', now(), '141500', 'седьмой пошел')," +
         "(42, 31000, 'MP335236', 'st_Pobedy7', '1985-01-02', now(), '151500', 'восьмой пошел')," +
         "(52, 41000, 'MP435236', 'st_Pobedy8', '1975-01-02', now(), '161500', 'девятый пошел')," +
         "(62, 51000, 'MP535236', 'st_Pobedy9', '1965-01-02', now(), '171500', 'десятый пошел')");
    }

    private static void printMetaData(Connection conn) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        String[] table = {"TABLE"};
        System.out.println(metaData);
        List<String> tablesList = new ArrayList<>();
        try (ResultSet rs = metaData.getTables("people", null, null,
                table)) {
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String tableName1 = rs.getString(5);//то же, что и выше строка только капсом выведет
                tablesList.add(tableName);
                System.out.println(tableName.toUpperCase() + tableName1);
                try (ResultSet rsColumn = metaData.getColumns("people", null, tableName,
                        null)) {
                    System.out.println(tableName.toUpperCase());//повторка
                    while (rsColumn.next()) {
                        System.out.println(rsColumn.getString("COLUMN_NAME") + " "
                                + rsColumn.getString("TYPE_NAME") + " "
                                + rsColumn.getString("COLUMN_SIZE"));
                    }
                }
            }
            System.out.println(tablesList);

        }
    }
}
