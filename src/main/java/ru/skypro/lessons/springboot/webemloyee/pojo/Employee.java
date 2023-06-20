package ru.skypro.lessons.springboot.webemployee.pojo;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Employee {
    private String name;
    private int salary;
}