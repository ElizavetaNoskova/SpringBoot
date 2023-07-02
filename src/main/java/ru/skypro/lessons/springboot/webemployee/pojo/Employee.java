package ru.skypro.lessons.springboot.webemployee.pojo;

import lombok.*;


@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Employee {
    private static int idGeneration = 1;
    private int id;
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.id = idGeneration++;
        this.name = name;
        this.salary = salary;
    }
}