package com.example.person.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person  {
    private int id;
    private int age;
    private int salary;
    private String passport;
    private String address;
    private LocalDate dateOfBirthday;
    private LocalDateTime dateTimeCreate;
    private LocalDateTime timeToLunch;
    private String letter;

    public Person(int id, int age, int salary, String passport, String address, LocalDate dateOfBirthday,
                  LocalDateTime dateTimeCreate, LocalDateTime timeToLunch, String letter) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.dateOfBirthday = dateOfBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public LocalDateTime getTimeToLunch() {
        return timeToLunch;
    }

    public void setTimeToLunch(LocalDateTime timeToLunch) {
        this.timeToLunch = timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
