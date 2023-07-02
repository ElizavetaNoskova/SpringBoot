package ru.skypro.lessons.springboot.webemployee.repository;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;
import ru.skypro.lessons.springboot.webemployee.pojo.Employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        employeeList.add(new Employee("Света", 120_000));
        employeeList.add(new Employee("Роман", 680_000));
        employeeList.add(new Employee("Александр", 70_000));
        employeeList.add(new Employee("Юрий", 830_000));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employeeList);
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public void update(int id, Employee employee) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employeeList.set(index, employee);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employeeList.remove(index);
        }
    }


}