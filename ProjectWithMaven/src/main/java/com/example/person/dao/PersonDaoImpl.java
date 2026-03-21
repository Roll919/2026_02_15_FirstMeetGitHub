package com.example.person.dao;

import com.example.person.dto.Person;

import java.io.Serializable;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person save(Person person) throws SQLException {
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
