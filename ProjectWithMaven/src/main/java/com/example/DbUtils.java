package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.time.LocalTime.now;

public class DbUtils {
    public static final String DB_NAME = "DB_people";
    public static final String URL_DB_CONN = "url";
    public static final String USER_DB_CONN = "user";
    public static final String PASS_DB_CONN = "password";
    public static final String SQL_TASK1 = "INSERT INTO person (age, salary, passport, address, dateOfBirthday," +
            "dateTimeCreate, timeToLunch, letter) VALUES (?,?,?,?,?,now(),?,?)";
    public static final Integer NUMBERS_OF_TIMES_AR = 5;

    public static final Integer[] arAge = {22, 32, 42, 52, 62};
    public static final Integer[] arSalary = {11000, 21000, 31000, 41000, 51000};
    public static final String[] arPassport = {"MP135236", "MP335237", "MP335238", "MP335239", "MP335240"};
    public static final String[] arAddress = {"stPobedy6", "stPobedy7", "stPobedy8", "stPobedy9", "stPobedy10"};
    public static final String[] arDateOfBirth = {"2005-01-02", "1995-01-02", "1985-01-02", "1975-01-02", "1965-01-02"};
    public static final String[] arTimeToLunch = {"13:15:00", "14:15:00", "15:15:00", "16:15:00", "17:15:00"};
    public static final String[] arLetter = {"шестой пошел", "седьмой пошел", "восьмой пошел", "девятый пошел", "десятый пошел"};

    public static final String TABLE_NAME = "TABLE_NAME";
    public static final String COLUMN_NAME = "COLUMN_NAME";
    public static final String TYPE_NAME = "TYPE_NAME";
    public static final String COLUMN_SIZE = "COLUMN_SIZE";
    public static final String PEOPLE = "people";
    public static final String TABLE = "TABLE";
    public static final String SELECT_FROM_PEOPLE_PERSON_WHERE_AGE_21_ORDER_BY_SALARY_DESC = "SELECT * FROM" +
            " people.person WHERE age > 21 ORDER BY salary desc ";

    public static Connection getConnection() throws SQLException {
        final ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_NAME);
        final String url = resourceBundle.getString(URL_DB_CONN);
        final String user = resourceBundle.getString(USER_DB_CONN);
        final String pass = resourceBundle.getString(PASS_DB_CONN);
        return DriverManager.getConnection(url, user, pass);
    }

    public static void printMetaData() throws SQLException {
        try (Connection conn = DbUtils.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            String[] table = {TABLE};
            System.out.println(metaData);
            List<String> tablesList = new ArrayList<>();
            try (ResultSet rs = metaData.getTables(PEOPLE, null, null,
                    table)) {
                while (rs.next()) {
                    String tableName = rs.getString(TABLE_NAME);
                    String tableName1 = rs.getString(5);//то же, что и выше строка только капсом выведет
                    tablesList.add(tableName);
                    System.out.println(tableName.toUpperCase() + tableName1);
                    try (ResultSet rsColumn = metaData.getColumns(PEOPLE, null, tableName,
                            null)) {
                        System.out.println(tableName.toUpperCase());//повторка
                        while (rsColumn.next()) {
                            System.out.println(rsColumn.getString(COLUMN_NAME) + " "
                                    + rsColumn.getString(TYPE_NAME) + " "
                                    + rsColumn.getString(COLUMN_SIZE));
                        }
                    }
                }
                System.out.println(tablesList);
            }
        }
    }

    public static void printDataDescSalary() throws SQLException {
        try (Connection conn = DbUtils.getConnection();
             Statement st = conn.createStatement()) {
            try (ResultSet rs1 = st.executeQuery(SELECT_FROM_PEOPLE_PERSON_WHERE_AGE_21_ORDER_BY_SALARY_DESC)) {
                ResultSetMetaData rsmd = rs1.getMetaData();
                int number = rsmd.getColumnCount();
                while (rs1.next()) {
                    for (int i = 1; i <= number; i++) {
                        String columnName = rsmd.getColumnName(i);
                        System.out.print(columnName + " " + rs1.getString(i) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void addFivePersons() throws SQLException {
        try (Connection conn = DbUtils.getConnection();
             PreparedStatement pstm = conn.prepareStatement((SQL_TASK1))) {
            for (int i = 0; i < NUMBERS_OF_TIMES_AR; i++) {
                pstm.setString(1, "arAge[i]");
                pstm.setString(2, "arSalary[i]");
                pstm.setString(3, arPassport[i]);
                pstm.setString(4, arAddress[i]);
                pstm.setObject(5, arDateOfBirth[i]);
                pstm.setString(6, arTimeToLunch[i]);
                pstm.setString(7, arLetter[i]);
                pstm.addBatch();
            }
            pstm.executeBatch();
        }
    }
}
