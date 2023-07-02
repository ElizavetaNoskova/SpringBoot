package ru.skypro.lessons.springboot.webemployee.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.webemployee.pojo.Employee;
import ru.skypro.lessons.springboot.webemployee.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.webemployee.exception.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.webemployee.exception.EmployeeNotValidException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Integer salarySum() {
        int sumSalary = 0;
        List<Integer> salaryList = employeeRepository.getAllEmployees()
                .stream()
                .map(Employee::getSalary)
                .toList();
        for (Integer salary : salaryList) {
            sumSalary = sumSalary + salary;
        }
        return sumSalary;
    }

    @Override
    public Employee findEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> aboveAverageSalary() {
        int sizeRepository = employeeRepository.getAllEmployees().size();
        int averageSalary = salarySum() / sizeRepository;
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }
    @Override
    public List<Employee> create(List<Employee> employeeList) {
        Optional<Employee> incorrectEmployee = employeeList.stream()
                .filter(employee -> employee.getSalary() <= 0 || employee.getName() == null || employee.getName().isEmpty())
                .findFirst();

        if(incorrectEmployee.isPresent()){
            throw new EmployeeNotValidException(incorrectEmployee.get());
        }
        return employeeList.stream()
                .map(employee -> new Employee(employee.getName(), employee.getSalary()))
                .map(employeeRepository::addEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public void update(int id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setName(employee.getName());
        employeeRepository.update(id, oldEmployee);
    }

    @Override
    public Employee get(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void delete(int id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> getEmployeeWithSalaryHigherThan(double salary) {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }
}