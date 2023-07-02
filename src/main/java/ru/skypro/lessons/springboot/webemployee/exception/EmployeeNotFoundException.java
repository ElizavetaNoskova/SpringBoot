package ru.skypro.lessons.springboot.webemployee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class EmployeeNotFoundException extends RuntimeException {

    private final int id;

}