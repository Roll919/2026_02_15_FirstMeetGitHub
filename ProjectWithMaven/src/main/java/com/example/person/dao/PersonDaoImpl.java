package com.example.person.dao;

import com.example.DbUtils;
import com.example.person.dto.Person;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.example.person.Constants5.*;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person save(Person person) throws SQLException {
        try (Connection connect = DbUtils.getConnection();
             PreparedStatement pstm = connect.prepareStatement(SQL_ADD_PERSON,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstm.setInt(1, person.getAge());
            pstm.setInt(2, person.getSalary());
            pstm.setString(3, person.getPassport());
            pstm.setString(4, person.getAddress());
            pstm.setObject(5, person.getDateOfBirthday());
            pstm.setObject(6, person.getTimeToLunch());
            pstm.setString(7, person.getLetter());
            pstm.executeUpdate();
            try (ResultSet generatedId = pstm.getGeneratedKeys()) {
                if (generatedId.next()) {
                    person.setId(generatedId.getInt(NUMBER_ONE));
                }
            }
        }
        return person;
    }


    @Override
    public Person get(Serializable id) throws SQLException {
        Person person = new Person();

        try (Connection connect = DbUtils.getConnection();
             PreparedStatement pstm = connect.prepareStatement(SQL_GET_PERSON)) {
            {
                pstm.setLong(1, (Long) id);
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        person.setId(rs.getInt(1));
                        person.setAge(rs.getInt(2));
                        person.setSalary(rs.getInt(3));
                        person.setPassport(rs.getString(4));
                        person.setAddress(rs.getString(5));
                        person.setDateOfBirthday(rs.getObject(6, LocalDate.class));
                        person.setDateTimeCreate(rs.getObject(7, LocalDateTime.class));
                        person.setTimeToLunch(rs.getObject(8, LocalTime.class));
                        person.setLetter(rs.getString(9));
                    }
                }
            }
            return person;
        }
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}

