package ru.skypro.lessons.springboot.webemployee.repository;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    public void update(int id, Employee employee);
    public Optional<Employee> findById(int id);
    public void delete(int id);
}