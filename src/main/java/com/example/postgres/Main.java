package com.example.postgres;

import com.example.postgres.DAO.CityDAO;
import com.example.postgres.DAO.CityDAOImpl;
import com.example.postgres.DAO.EmployeeDAO;
import com.example.postgres.DAO.EmployeeDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        City city1 = new City(1, "Самара");
        City city2 = new City(2, "Москва");
        Employee employee = new Employee("Валерия", "Дьяченко", "female", 23, city1);
        employeeDAO.addEmployee(employee);
        System.out.println(employeeDAO.getById(2));

        List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());
        for(Employee empl : list){
            System.out.println(empl);
        }
        employeeDAO.updateEmployeeById(3, "Степан", "Логинов", "male", 49, city2);

        employeeDAO.deleteById(employee);

        CityDAO cityDAO = new CityDAOImpl();

        City newCity = new City(6, "Тверь");
        cityDAO.addCity(newCity);

        System.out.println(cityDAO.getCityById(3));

        List<City> cities = new ArrayList<>(cityDAO.getAllCities());
        for (City cityFromList : cities) {
            System.out.println(cityFromList);
        }

        cityDAO.updateCityById(4, "Казань");
    }
}