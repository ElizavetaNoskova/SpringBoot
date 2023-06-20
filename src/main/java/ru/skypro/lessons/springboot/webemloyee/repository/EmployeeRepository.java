package ru.skypro.lessons.springboot.webemployee.repository;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();
}