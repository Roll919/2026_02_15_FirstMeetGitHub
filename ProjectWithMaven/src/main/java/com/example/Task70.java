package com.example;/*
2025_12_07
Задание 70
Создать класс Man c произвольным набором полей и методов (не менее 3) Создать метод, который распечатает
информацию о классе с помощью рефлексии. Вызвать метод с помощью рефлексии из основной программы.
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task70 {
    public static void main(String[] args) {
        Task70_Man man = new Task70_Man("Павел");
        //  inspectObjectByReflect(man);
        inspectClassByReflect(Task70_Man.class);
    }

    public static <T> void inspectClassByReflect(Class<T> aClass) {
        try {
            Field[] listFields = aClass.getDeclaredFields();
            Method[] listMethods = aClass.getDeclaredMethods();
            System.out.println("Поля класса:");
            for (Field listField : listFields) {
                System.out.println(listField.getName());
            }
            System.out.println("Методы класса:");
            for (Method listMethod : listMethods) {
                System.out.println(listMethod.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inspectObjectByReflect(Object object) {
        try {
            Class<?> clazz = object.getClass();
            Field[] listFields = clazz.getDeclaredFields();
            Method[] listMethods = clazz.getDeclaredMethods();
            System.out.println("Поля класса:");
            for (Field listField : listFields) {
                System.out.println(listField);
            }
            System.out.println("Методы класса:");
            for (Method listMethod : listMethods) {
                System.out.println(listMethod);
            }
        } catch (Exception e) {
            System.out.println("ой");
        }
    }
}
