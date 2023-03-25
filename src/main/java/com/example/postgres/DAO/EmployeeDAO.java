package com.example.postgres.DAO;

import com.example.postgres.Employee;
import com.example.postgres.City;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee (Employee employee);

    Employee getById (int id);

    List<Employee> getAllEmployees ();


    void updateEmployeeById(Employee employee);

    void deleteById(Employee employee);
}
