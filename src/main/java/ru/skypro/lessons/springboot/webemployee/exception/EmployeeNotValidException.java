package ru.skypro.lessons.springboot.webemployee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

@AllArgsConstructor
@Getter
public class EmployeeNotValidException extends RuntimeException {

    private final Employee employee;

}