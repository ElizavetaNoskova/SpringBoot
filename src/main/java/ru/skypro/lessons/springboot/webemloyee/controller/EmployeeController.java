package ru.skypro.lessons.springboot.webemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.webemployee.pojo.Employee;
import ru.skypro.lessons.springboot.webemployee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/salary/max")
    public Employee findEmployeeWithMaxSalary() {
        return employeeService.findEmployeeWithMaxSalary();
    }

    @GetMapping("/salary/min")
    public Employee findEmployeeWithMinSalary() {
        return employeeService.findEmployeeWithMinSalary();
    }

    @GetMapping("/salary/sum")
    public Integer salarySum() {
        return employeeService.salarySum();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.aboveAverageSalary();
    }
}
