package ru.skypro.lessons.springboot.webemployee.controller;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public List<Employee> create(@RequestBody List<Employee> employeeList){
        return employeeService.create(employeeList);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee){
        employeeService.update(id, employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id){
        return employeeService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeeWithSalaryHigherThan(@RequestParam int salary){
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }
}
