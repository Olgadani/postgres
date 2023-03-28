package com.example.postgres.DAO;

import com.example.postgres.Employee;
import com.example.postgres.City;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee (Employee employee);

    Employee getById (Integer id);

    List<Employee> getAllEmployees ();


    void updateEmployeeById(Integer id, String first_name, String last_name, String gender, int age, City city);

    void deleteById(Employee employee);
}
