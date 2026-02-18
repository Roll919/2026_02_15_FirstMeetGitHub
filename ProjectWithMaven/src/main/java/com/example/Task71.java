package com.example;/*
2025_12_07
Задание 71
Создайте класс с методов printHelloWorld(). Вызвать метод с помощью
рефлексии из основной программы.
*/

import java.lang.reflect.Method;

public class Task71 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Task71_HW.class;
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Method m = clazz.getDeclaredMethod("printHelloWorld");
            m.invoke(instance);
        } catch (
                Exception e) {

            e.printStackTrace();
        }
    }
}
