package com.example.person.dao;

import com.example.DbUtils;
import com.example.person.dto.Person;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import static com.example.DbUtils.*;
import static com.example.person.Constants5.SQL_ADD_PERSON;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person save(Person person) throws SQLException {
        try (Connection connect = DbUtils.getConnection();
                PreparedStatement pstm = connect.prepareStatement(SQL_ADD_PERSON)) {
            Integer rand = new Random().nextInt(5);
            pstm.setString(1, "arAge[rand]");
            pstm.setString(2, "arSalary[rand]");
            pstm.setString(3, arPassport[rand]);
            pstm.setString(4, arAddress[rand]);
            pstm.setObject(5, arDateOfBirth[rand]);
            pstm.setString(6, arTimeToLunch[rand]);
            pstm.setString(7, arLetter[rand]);
            }
        return null;
    }


    @Override
    public Person get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}
