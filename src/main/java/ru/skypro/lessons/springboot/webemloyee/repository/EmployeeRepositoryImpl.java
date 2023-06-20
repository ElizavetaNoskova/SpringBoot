package ru.skypro.lessons.springboot.webemployee.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.webemployee.pojo.Employee;
import ru.skypro.lessons.springboot.webemployee.repository.EmployeeRepository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = List.of(
            new Employee("Света", 120_000),
            new Employee("Роман", 680_000),
            new Employee("Александр", 70_000),
            new Employee("юрий", 830_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}