package com.example;/* 2025_12_07
Задание 72
Создать собственную аннотацию @academyinfo c полем year. Создать метод,  помеченный этой анотацией с
заданным year и метод без нее. С помощью рефлексии проверить наличие данной аннотации у этих методов из
основной программы.*/

import java.lang.reflect.Method;

public class Task72 {
    @Task72_AnnotAcadInfo(infoYear = 2026)
    public void print() {
        System.out.println("Академия");
    }

    public void print1() {
        System.out.println("Академия1");
    }

    public static void main(String[] args) {
        try {
            Class<? extends Task72> aClass = Task72.class;
            Method[] methods = aClass.getDeclaredMethods();
            System.out.println("Методы класса:");
            for (Method element : methods) {
                System.out.println(element.getName());
                Task72_AnnotAcadInfo myAnnot = element.getAnnotation(Task72_AnnotAcadInfo.class);
                if ( myAnnot == null) {
                    System.out.println(element + " не имеет такой аннотации");
                } else System.out.println(element.getName() + " его аннотация=" + myAnnot.infoYear());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
