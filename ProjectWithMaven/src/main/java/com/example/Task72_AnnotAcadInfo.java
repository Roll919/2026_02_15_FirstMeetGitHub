package com.example;/* 2025_12_07
Задание 72
Создать собственную аннотацию @academyinfo c полем year. Создать метод,  помеченный этой анотацией с
заданным year и метод без нее. С помощью рефлексии проверить наличие данной аннотации у этих методов из
основной программы.*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})

public @interface Task72_AnnotAcadInfo {
    int infoYear();
}
