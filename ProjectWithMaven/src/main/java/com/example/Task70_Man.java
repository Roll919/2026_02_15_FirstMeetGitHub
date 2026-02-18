package com.example;/*
2025_12_07
Задание 70
Создать класс Man c произвольным набором полей и методов (не менее 3) Создать метод, который распечатает
информацию о классе с помощью рефлексии. Вызвать метод с помощью рефлексии из основной программы.
*/

public class Task70_Man {
    private String name;
    private String surname;
    private int age;

    public Task70_Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
