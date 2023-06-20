package ru.skypro.lessons.springboot.webemployee.service;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findEmployeeWithMaxSalary();
    Employee findEmployeeWithMinSalary();
    Integer salarySum();
    List<Employee> aboveAverageSalary();

}